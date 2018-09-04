package org.rapidpm.vaadin.api.fluent.builder.layout.vertical;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Setter;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface VerticalLayoutMixin extends ComponentMixin<VerticalLayout> {

  //for typing
  default <V> VerticalLayoutMixin set(Setter<VerticalLayout, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }



//  delegating to add methods with void return







  //delegating
  default VerticalLayoutMixin setSpacing(boolean spacing) {
    return set(VerticalLayout::setSpacing, spacing);
  }

  default VerticalLayoutMixin setPadding(boolean padding) {
    return set(VerticalLayout::setPadding, padding);
  }

  default VerticalLayoutMixin setHorizontalComponentAlignment(FlexComponent.Alignment alignment, Component... componentsToAlign) {
    component().ifPresent(c -> c.setHorizontalComponentAlignment(alignment, componentsToAlign));
    return this;
  }

  default VerticalLayoutMixin setDefaultHorizontalComponentAlignment(FlexComponent.Alignment alignment) {
    return set(VerticalLayout::setDefaultHorizontalComponentAlignment, alignment);
  }

  default VerticalLayoutMixin setAlignItems(FlexComponent.Alignment alignment) {
    return set(VerticalLayout::setAlignItems, alignment);
  }

  default VerticalLayoutMixin setAlignSelf(FlexComponent.Alignment alignment, HasElement... elementContainers) {
    component().ifPresent(c -> c.setAlignSelf(alignment, elementContainers));
    return this;
  }

  @Override
  default VerticalLayoutMixin setId(String id) {
    return set(VerticalLayout::setId, id);
  }

  @Override
  default VerticalLayoutMixin setVisible(boolean visible) {
    return set(VerticalLayout::setVisible, visible);
  }

  default VerticalLayoutMixin setMargin(boolean margin) {
    return set(VerticalLayout::setMargin, margin);
  }

  default VerticalLayoutMixin setBoxSizing(BoxSizing boxSizing) {
    return set(VerticalLayout::setBoxSizing, boxSizing);
  }

  default VerticalLayoutMixin setFlexGrow(double flexGrow, HasElement... elementContainers) {
    component().ifPresent(c -> c.setFlexGrow(flexGrow, elementContainers));
    return this;
  }

  default VerticalLayoutMixin setJustifyContentMode(FlexComponent.JustifyContentMode justifyContentMode) {
    return set(VerticalLayout::setJustifyContentMode, justifyContentMode);
  }

  default VerticalLayoutMixin setEnabled(boolean enabled) {
    return set(VerticalLayout::setEnabled, enabled);
  }

  default VerticalLayoutMixin setClassName(String className) {
    return set(VerticalLayout::setClassName, className);
  }

  default VerticalLayoutMixin setClassName(String className, boolean set) {
    component().ifPresent(c -> c.setClassName(className, set));
    return this;
  }

  default VerticalLayoutMixin setWidth(String width) {
    return set(VerticalLayout::setWidth, width);
  }

  default VerticalLayoutMixin setHeight(String height) {
    return set(VerticalLayout::setHeight, height);
  }

  default VerticalLayoutMixin setSizeFull() {
    component().ifPresent(HasSize::setSizeFull);
    return this;
  }

  default VerticalLayoutMixin setSizeUndefined() {
    component().ifPresent(HasSize::setSizeUndefined);
    return this;
  }
}
