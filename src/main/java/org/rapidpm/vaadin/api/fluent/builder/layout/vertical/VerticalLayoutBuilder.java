package org.rapidpm.vaadin.api.fluent.builder.layout.vertical;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.rapidpm.vaadin.api.fluent.builder.ComponentHolder;

import java.util.Optional;
import java.util.function.Supplier;

public class VerticalLayoutBuilder
    extends ComponentHolder<VerticalLayout>
    implements VerticalLayoutMixin {

  public VerticalLayoutBuilder(Optional<VerticalLayout> component) {
    super(component);
  }

  public VerticalLayoutBuilder(Supplier<VerticalLayout> supplier) {
    super(supplier);
  }
}
