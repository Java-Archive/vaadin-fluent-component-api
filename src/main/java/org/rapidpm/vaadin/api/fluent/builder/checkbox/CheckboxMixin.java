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
package org.rapidpm.vaadin.api.fluent.builder.checkbox;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.binder.Setter;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface CheckboxMixin extends ComponentMixin<Checkbox> {

  @Override
  default <V> CheckboxMixin set(Setter<Checkbox, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }


  default CheckboxMixin setLabel(String label) {
    return set(Checkbox::setLabel, label);
  }

  default CheckboxMixin setLabelAsHtml(String htmlContent) {
    return set(Checkbox::setLabelAsHtml, htmlContent);
  }

  default CheckboxMixin setAriaLabel(String ariaLabel) {
    return set(Checkbox::setAriaLabel, ariaLabel);
  }

  default CheckboxMixin setAutofocus(boolean autofocus) {
    return set(Checkbox::setAutofocus, autofocus);
  }

  default CheckboxMixin setIndeterminate(boolean indeterminate) {
    return set(Checkbox::setIndeterminate, indeterminate);
  }

  default CheckboxMixin setValue(Boolean value) {
    return set(Checkbox::setValue, value);
  }

  @Override
  default CheckboxMixin setId(String id) {
    return set(Checkbox::setId, id);
  }

  @Override
  default CheckboxMixin setVisible(boolean visible) {
    return set(Checkbox::setVisible, visible);
  }

  default CheckboxMixin setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
    return set(Checkbox::setRequiredIndicatorVisible, requiredIndicatorVisible);
  }

  default CheckboxMixin setReadOnly(boolean readOnly) {
    return set(Checkbox::setReadOnly, readOnly);
  }

  default CheckboxMixin setEnabled(boolean enabled) {
    return set(Checkbox::setEnabled, enabled);
  }

  default CheckboxMixin setClassName(String className) {
    return set(Checkbox::setClassName, className);
  }

  default CheckboxMixin setClassName(String className, boolean set) {
    component().ifPresent(c -> setClassName(className, set));
    return this;
  }

  default CheckboxMixin setTabIndex(int tabIndex) {
    return set(Checkbox::setTabIndex, tabIndex);
  }

  default CheckboxMixin setWidth(String width) {
    return set(Checkbox::setWidth, width);
  }

  default CheckboxMixin setHeight(String height) {
    return set(Checkbox::setHeight, height);
  }

  default CheckboxMixin setSizeFull() {
    component().ifPresent(HasSize::setSizeFull);
    return this;
  }

  default CheckboxMixin setSizeUndefined() {
    component().ifPresent(HasSize::setSizeUndefined);
    return this;
  }
}
