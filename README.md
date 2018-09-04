<center>
<a href="https://vaadin.com">
 <img src="https://vaadin.com/images/hero-reindeer.svg" width="200" height="200" /></a>
</center>

# Vaadin Fluent Component API
The missing Fluent API for Vaadin 10 Components.

## 00.01.00-RPM
* Component - the generic version
* TextField
* PasswordField
* Button
* Checkbox
* VerticalLayout
* HorizontalLayout


## How to run the demo
To run the demo, start the Servlet-Container. Here we are using Apache Meecrowave.
The code you will find under **test/java/demo**

```java
public class BasicTestUIRunner {
  private BasicTestUIRunner() {
  }

  public static void main(String[] args) {
    new Meecrowave(new Meecrowave.Builder() {
      {
//        randomHttpPort();
        setHttpPort(8080);
        setTomcatScanning(true);
        setTomcatAutoSetup(true);
        setHttp2(true);
      }
    })
        .bake()
        .await();
  }
}
```

With this few lines of code we are able to start the container and the Vaadin app
will be initialized. The App is running at [http://127.0.0.1:8080](http://127.0.0.1:8080)

## The basic ideas behind...
If you are using Vaadin, mostly your code ends up like the following.

Let´s assume you want to create a ```PasswordField```
For this you will start with the instantiation of the class.

### The recommended Vaadin way
But first we will do it in the original Vaadin way.
The PasswordField will be created as attribute 
or as inner field inside the init block, mostly the constructor.

```java
    final PasswordField password = new PasswordField();
    password.setPlaceholder("password");
    password.setId("pf-password-id");
    password.setValueChangeMode(ValueChangeMode.EAGER);
    password.setVisible(true);
    password.setRequired(true);
```

If it is only like this, it looks ok so far. But if the attribute is 
needed in a more global context, let´s say as class attribute, 
you have to maintain at least two places. First the place where 
the attribute will be defined and second the place where you are initialising 
the attribute itself. 

```java
    final PasswordField password = new PasswordField();

    public MyClass(){
      password.setPlaceholder("password");
      password.setId("pf-password-id");
      password.setValueChangeMode(ValueChangeMode.EAGER);
      password.setVisible(true);
      password.setRequired(true);      
    }
```

### inner non static blocks
If you want to hold the definition of the attribute and 
the initialising near together you could think about using 
inner non - static blocks. At the first view, it looks 
nice. Both things are near together. But would this 
solution be refactoring safe? Well, if inner non-static 
blocks are used, the developer must know at what time 
each block and the constructor will be called. 
Order matters here and the IDE is mostly not able to support you
during refactorings.

```java
    final PasswordField password = new PasswordField();

    {
      password.setPlaceholder("password");
      password.setId("pf-password-id");
      password.setValueChangeMode(ValueChangeMode.EAGER);
      password.setVisible(true);
      password.setRequired(true);      
    }
```

### Anonymous Inner Class 
One other way is the usage of the **double curly braces** pattern.
If you are searching about more information's about this 
you will find a lot of descriptions that this is an anti-pattern.
Have in mind that most posts are from the year 2014/2015.
The main points are, 
1. that a lot of anonymous classes are created
2. a reference is hold between holding class and anonymous class

Both arguments are not as bad as it looks like.
Other languages like Kotlin and Scala are creating a lot of 
classes and the even the implementation of an ActionListener
is mostly a anonymous class as well. So this is something, 
the GC can handle quite well. To get a few information's about it,
use the following flags and enjoy reading the GC Logs. 

* **-XX:-TraceClassLoading**	        Trace loading of classes.
* **-XX:-TraceClassLoadingPreorder**	Trace all classes loaded in order referenced (not loaded). 
* **-XX:-TraceClassResolution**	        Trace constant pool resolutions. 
* **-XX:-TraceClassUnloading**	        Trace unloading of classes.
* **-XX:-TraceLoaderConstraints**       Trace recording of loader constraints.

The little bit more biting fact is the reference itself.
As long as you are not sharing references across the application, 
this is never a bigger challenge for the GC. So, have in mind.
Don´t share the references, hold them inside your *View*.

If you are using this, you code looks like the following.

```java
    final PasswordField password = new PasswordField() {{
      setPlaceholder("password");
      setId("pf-password-id");
      setValueChangeMode(ValueChangeMode.EAGER);
      setVisible(true);
      setRequired(true);      
    }}
```
Now, the creation of the instance and the initializing is near together.
The IDE can support you as well. But Maybe this is not what you want to do.
What could be the next solution? 

### Optional or something similar
Since Java8 we have the class Optional and we could use this
to hold the definition and the initialising near together.
You can, somehow use the method **ifPresent**.
This would not create anonymous classes and no reference 
you should have an eye on.

```java
    final PasswordField password = Optional.of(new PasswordField())
     .ifPresent( pf -> {
             pf.setPlaceholder("password");
             pf.setId("pf-password-id");
             pf.setValueChangeMode(ValueChangeMode.EAGER);
             pf.setVisible(true);
             pf.setRequired(true);
     })
     .get();
```

## Fluent API
Finally we are at the point to have a few on the 
Fluent API for Vaadin. There are at least two different ways you can add
the fluent api into the Vaadin Components.
The oo-style would be the way to extend the Components itself.
This would lead to a parallel Class - hierarchy. For sure, you can downcast 
every time to the original class, but the main thing is.
The fluent API is part of the component itself. 
My point of view is different. I don´t want to have this 
as part of the component itself. And  I don´t want to 
create the parallel class hierarchy. I prefer a solution that 
can be used in new and in old projects at the same time.
And I don´t want to force the developer every time to use this.

One big thing is, how you can deal with existing code.
If there is a existing component, and I want to invoke a few methods,
I can not or don´t want to create a new instance.
The fluent API should be usable for pre-initialized objects as well.

### The generic way
First we will have a look at the generic version of the fluent API.
This is important, because this is the fall back if the fluent api is missing a method
or you want to use the fluent API for your own components without 
writing corresponding the fluent API.

The Vaadin platform itself brings a few nice things, that we can use.
For example, the data binding is using a Functional Interface called 
```Setter<T, V>```. 

```java
@FunctionalInterface
public interface Setter<BEAN, FIELDVALUE> extends BiConsumer<BEAN, FIELDVALUE>, Serializable {
  void accept(BEAN var1, FIELDVALUE var2);
}
````
With this we an attribute can be set with a value.
The usage looks like th following.

```java
    Setter<PasswordField, String> setter = new Setter<PasswordField, String>() {
      @Override
      public void accept(PasswordField passwordField, String value) {
        passwordField.setId(value);
      }
    };
    setter.accept(password, "id" );
``` 
This we can now refactor to some more compact code.
First we are transforming the inner anonymous class into a Lambda construct.

```java 
    Setter<PasswordField, String> setter 
        = (Setter<PasswordField, String>) (passwordField, value) -> passwordField.setId(value);
    setter.accept(password, "id" );
```

We can remove the Type - declaration and using more generic names for the parameters.

```java
   Setter<PasswordField, String> setter 
        = (bean, value) -> bean.setId(value);
    setter.accept(password, "id" );
```
Now we can convert the Lambda construct into the usage of a method reference.

```java
    Setter<PasswordField, String> setter 
        = Component::setId;
    setter.accept(password, "id" );
```

The code is quite compact now. The next step is the abstraction of the 
definition what to do from the usage itself.
The definition, what to do, we can write as function. For this we
define an interface called ```ComponentMixin<T extends Component>```.
The instance of the component itself will be hold inside an Optional.
But we are not defining an attribute, we are only defining the way how to get it.
Now we can declare the generic way, how to set an attribute plus the return value,
the instance itself.

```java
public interface ComponentMixin<T extends Component> {

  Optional<T> component();

  default <V> ComponentMixin<T> set(Setter<T, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }
}
```

On the other side, we need the place to hold the instance of the component itself.
This is done inside the class called ```ComponentHolder<T extends Component>```

```java
public class ComponentHolder<T extends Component> {

  private Optional<T> component;

  public ComponentHolder(Optional<T> component) {
    this.component = component;
  }

  public ComponentHolder(Supplier<T> supplier) {
    this.component = ofNullable(supplier.get());
  }

  public Optional<T> component() {
    return component;
  }
}
```

With this we have now divided the stateful and the stateless part. Both together
will be called ```ComponentBuilder```.

```java
public class ComponentBuilder
    extends ComponentHolder<Component>
    implements ComponentMixin {

  public ComponentBuilder(Optional<Component> component) {
    super(component);
  }

  public ComponentBuilder(Supplier<Component> supplier) {
    super(supplier);
  }
}
```

Now it is time to create the basic UI to show how we can use a 
generic ComponentBuilder. The example will show how to create an instance of a 
PasswordField. 

```java
  private final PasswordField password = (PasswordField) new ComponentBuilder(PasswordField::new)
      .setId("pf-password-id")
      .set((Setter<PasswordField, String>) PasswordField::setPlaceholder, "password")
      .build();
```

As you could see clearly, this is not nice because we have to put to much 
type information´s into the code itself. For this there are 
special Builder provided, like the ```PasswordFieldBuilder```


```java
  private final PasswordField password = new PasswordFieldBuilder(PasswordField::new)
      .setId("pf-password-id")
      .setPlaceholder("password")
      .build();
```

If you have an instance already, you can use this one as well.
Working with typed Composites will give you an already created instance of
the type that is used inside the declaration.
The demo app ist using a ```Composite<HorizontalLayout>``` as base.
The method **getContent()** will give you exactly this instance.
To configure the instance, use this on as input for the Builder.

```java
  public LoginView() {
    new HorizontalLayoutBuilder(ofNullable(getContent()))
        .setDefaultVerticalComponentAlignment(Alignment.CENTER)
        .setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER)
        .setSizeFull()
        .component()
        .ifPresent(l -> l.add(layout));
  }
```

This Add on is under active development.
If you need some features, or more wrapped Components.... let me know
You can reach me under my email or via Twitter (@SvenRuppert)

Happy coding




