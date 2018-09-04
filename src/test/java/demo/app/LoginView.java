/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.app;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.rapidpm.vaadin.api.fluent.builder.button.ButtonBuilder;
import org.rapidpm.vaadin.api.fluent.builder.checkbox.CheckboxBuilder;
import org.rapidpm.vaadin.api.fluent.builder.layout.horizontal.HorizontalLayoutBuilder;
import org.rapidpm.vaadin.api.fluent.builder.layout.vertical.VerticalLayoutBuilder;
import org.rapidpm.vaadin.api.fluent.builder.passwordfield.PasswordFieldBuilder;
import org.rapidpm.vaadin.api.fluent.builder.textfield.TextFieldBuilder;

import static demo.app.LoginView.NAV_LOGIN_VIEW;
import static java.util.Optional.ofNullable;

@Route(NAV_LOGIN_VIEW)
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class LoginView extends Composite<HorizontalLayout> {

  public static final String NAV_LOGIN_VIEW = "";

  private final TextField username = new TextFieldBuilder(TextField::new)
      .set(Component::setId, "tf-username-id")
      .setPlaceholder("User Name") //.set(TextField::setPlaceholder, "User Name")
      .component()
      .get();

  private final PasswordField password = new PasswordFieldBuilder(PasswordField::new)
      .setId("pf-password-id")
      .setPlaceholder("password")
      .build();


  private final Checkbox rememberMe = new CheckboxBuilder(Checkbox::new)
      .setId("cb-remember-me-id")
      .setLabel("remember me")
      .setIndeterminate(false)
      .build();

  private final Button btnLogin = new ButtonBuilder(Button::new)
      .setId("btn-login-id")
      .setText("Login")
      .component()
      .map(btn -> {
        Registration registration = btn.addClickListener(e -> validate());
        // if you want to do something with this....
        return btn;
      })
      .get();

  private final Button btnCancel = new ButtonBuilder(Button::new)
      .setId("btn-cacnel-id")
      .setText("Cancel")
      .component()
      .map(btn -> {
        Registration registration = btn.addClickListener(e -> clearFields());
        // if you want to do something with this....
        return btn;
      })
      .get();

  private final VerticalLayout layout = new VerticalLayoutBuilder(VerticalLayout::new)
      .setDefaultHorizontalComponentAlignment(Alignment.START)
      .setSizeUndefined()
      .component()
      .map(l -> {
        l.add(new HorizontalLayout(username, password), rememberMe, new HorizontalLayout(btnLogin, btnCancel));
        return l;
      })
      .get();


  public LoginView() {
    new HorizontalLayoutBuilder(ofNullable(getContent()))
        .setDefaultVerticalComponentAlignment(Alignment.CENTER)
        .setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER)
        .setSizeFull()
        .component()
        .ifPresent(l -> l.add(layout));
  }

  private void clearFields() {
    username.clear();
    password.clear();
  }

  public String username() {
    return username.getValue();
  }

  public String password() {
    return password.getValue();
  }

  public Boolean rememberMe() {
    return rememberMe.getValue();
  }

  private void validate() {

    boolean isValid = checkCredentials();
    if (isValid) {
      navigateToApp();
    } else {
      reactOnFailedLogin();
    }
    clearFields();
  }

  public void reactOnFailedLogin() {
    Notification.show("Wrong credentials! ");
  }

  public void navigateToApp() {
    UI.getCurrent().navigate(MainView.class);
  }

  public boolean checkCredentials() {
    return username().equals("admin") && password().equals("admin");
  }
}
