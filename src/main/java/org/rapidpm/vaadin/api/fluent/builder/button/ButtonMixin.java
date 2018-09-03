/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rapidpm.vaadin.api.fluent.builder.button;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.binder.Setter;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface ButtonMixin extends ComponentMixin<Button> {

  //delegate

  @Override
  default <V> ButtonMixin set(Setter<Button, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }

  default ButtonMixin setText(String text) {
    return set(Button::setText, text);
  }

  default ButtonMixin setIcon(Component icon) {
    return set(Button::setIcon, icon);
  }

  default ButtonMixin setIconAfterText(boolean iconAfterText) {
    return set(Button::setIconAfterText, iconAfterText);
  }

  default ButtonMixin setAutofocus(boolean autofocus) {
    return set(Button::setAutofocus, autofocus);
  }

  @Override
  default ButtonMixin setId(String id) {
    return set(Button::setId, id);
  }

  @Override
  default ButtonMixin setVisible(boolean visible) {
    return set(Button::setVisible, visible);
  }

  default ButtonMixin setClassName(String className) {
    return set(Button::setClassName, className);
  }

  default ButtonMixin setClassName(String className, boolean set) {
    component().ifPresent(c -> c.setClassName(className, set));
    return this;
  }

  default ButtonMixin setTabIndex(int tabIndex) {
    return set(Button::setTabIndex, tabIndex);
  }

  default ButtonMixin setEnabled(boolean enabled) {
    return set(Button::setEnabled, enabled);
  }

  default ButtonMixin setWidth(String width) {
    return set(Button::setWidth, width);
  }

  default ButtonMixin setHeight(String height) {
    return set(Button::setHeight, height);
  }

  default ButtonMixin setSizeFull() {
    component().ifPresent(HasSize::setSizeFull);
    return this;
  }

  default ButtonMixin setSizeUndefined() {
    component().ifPresent(HasSize::setSizeUndefined);
    return this;
  }
}
