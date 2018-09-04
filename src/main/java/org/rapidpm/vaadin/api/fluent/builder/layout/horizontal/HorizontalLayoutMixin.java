package org.rapidpm.vaadin.api.fluent.builder.layout.horizontal;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Setter;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface HorizontalLayoutMixin extends ComponentMixin<HorizontalLayout> {

  //for typing
  default <V> HorizontalLayoutMixin set(Setter<HorizontalLayout, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }

  //delegating
  default HorizontalLayoutMixin setSpacing(boolean spacing) {
    return set(HorizontalLayout::setSpacing, spacing);
  }

  default HorizontalLayoutMixin setPadding(boolean padding) {
    return set(HorizontalLayout::setPadding, padding);
  }

  default HorizontalLayoutMixin setVerticalComponentAlignment(FlexComponent.Alignment alignment, Component... componentsToAlign) {
    component().ifPresent(c -> c.setVerticalComponentAlignment(alignment, componentsToAlign));
    return this;
  }

  default HorizontalLayoutMixin setDefaultVerticalComponentAlignment(FlexComponent.Alignment alignment) {
    return set(HorizontalLayout::setDefaultVerticalComponentAlignment, alignment);
  }

  default HorizontalLayoutMixin setAlignItems(FlexComponent.Alignment alignment) {
    return set(HorizontalLayout::setAlignItems, alignment);
  }

  default HorizontalLayoutMixin setAlignSelf(FlexComponent.Alignment alignment, HasElement... elementContainers) {
    component().ifPresent(c -> c.setAlignSelf(alignment, elementContainers));
    return this;
  }

  @Override
  default HorizontalLayoutMixin setId(String id) {
    return set(HorizontalLayout::setId, id);
  }

  @Override
  default HorizontalLayoutMixin setVisible(boolean visible) {
    return set(HorizontalLayout::setVisible, visible);
  }

  default HorizontalLayoutMixin setMargin(boolean margin) {
    return set(HorizontalLayout::setMargin, margin);
  }

  default HorizontalLayoutMixin setBoxSizing(BoxSizing boxSizing) {
    return set(HorizontalLayout::setBoxSizing, boxSizing);
  }

  default HorizontalLayoutMixin setFlexGrow(double flexGrow, HasElement... elementContainers) {
    component().ifPresent(c -> c.setFlexGrow(flexGrow, elementContainers));
    return this;
  }

  default HorizontalLayoutMixin setJustifyContentMode(FlexComponent.JustifyContentMode justifyContentMode) {
    return set(HorizontalLayout::setJustifyContentMode, justifyContentMode);
  }

  default HorizontalLayoutMixin setEnabled(boolean enabled) {
    return set(HorizontalLayout::setEnabled, enabled);
  }

  default HorizontalLayoutMixin setClassName(String className) {
    return set(HorizontalLayout::setClassName, className);
  }

  default HorizontalLayoutMixin setClassName(String className, boolean set) {
    component().ifPresent(c -> c.setClassName(className, set));
    return this;
  }

  default HorizontalLayoutMixin setWidth(String width) {
    return set(HorizontalLayout::setWidth, width);
  }

  default HorizontalLayoutMixin setHeight(String height) {
    return set(HorizontalLayout::setHeight, height);
  }

  default HorizontalLayoutMixin setSizeFull() {
    component().ifPresent(HasSize::setSizeFull);
    return this;
  }

  default HorizontalLayoutMixin setSizeUndefined() {
    component().ifPresent(HasSize::setSizeUndefined);
    return this;
  }

}
