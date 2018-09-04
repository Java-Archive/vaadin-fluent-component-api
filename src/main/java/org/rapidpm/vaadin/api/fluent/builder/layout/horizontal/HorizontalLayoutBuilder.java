package org.rapidpm.vaadin.api.fluent.builder.layout.horizontal;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.rapidpm.vaadin.api.fluent.builder.ComponentHolder;

import java.util.Optional;
import java.util.function.Supplier;

public class HorizontalLayoutBuilder
    extends ComponentHolder<HorizontalLayout>
    implements HorizontalLayoutMixin {

  public HorizontalLayoutBuilder(Optional<HorizontalLayout> component) {
    super(component);
  }

  public HorizontalLayoutBuilder(Supplier<HorizontalLayout> supplier) {
    super(supplier);
  }
}
