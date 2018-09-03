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
package org.rapidpm.vaadin.api.fluent.builder.textfield;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface TextFieldMixin extends ComponentMixin<TextField> {

  //for typing
  default <V> TextFieldMixin set(Setter<TextField, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }

  //delegating
  default TextFieldMixin setValueChangeMode(ValueChangeMode valueChangeMode) {
    return set(TextField::setValueChangeMode, valueChangeMode);
  }

  default TextFieldMixin setErrorMessage(String errorMessage) {
    return set(TextField::setErrorMessage, errorMessage);
  }

  default TextFieldMixin setInvalid(boolean invalid) {
    return set(TextField::setInvalid, invalid);
  }

  default TextFieldMixin setLabel(String label) {
    return set(TextField::setLabel, label);
  }

  default TextFieldMixin setPlaceholder(String placeholder) {
    return set(TextField::setPlaceholder, placeholder);
  }

  default TextFieldMixin setAutofocus(boolean autofocus) {
    return set(TextField::setAutofocus, autofocus);
  }

  default TextFieldMixin setMaxLength(int maxLength) {
    return set(TextField::setMaxLength, maxLength);
  }

  default TextFieldMixin setMinLength(int minLength) {
    return set(TextField::setMinLength, minLength);
  }

  default TextFieldMixin setRequired(boolean required) {
    return set(TextField::setRequired, required);
  }

  default TextFieldMixin setPreventInvalidInput(boolean preventInvalidInput) {
    return set(TextField::setPreventInvalidInput, preventInvalidInput);
  }

  default TextFieldMixin setPattern(String pattern) {
    return set(TextField::setPattern, pattern);
  }

  default TextFieldMixin setTitle(String title) {
    return set(TextField::setTitle, title);
  }

  default TextFieldMixin setValue(String value) {
    return set(TextField::setValue, value);
  }

  default TextFieldMixin setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
    return set(TextField::setRequiredIndicatorVisible, requiredIndicatorVisible);
  }

  default TextFieldMixin setId(String id) {
    return set(TextField::setId, id);
  }

  default TextFieldMixin setVisible(boolean visible) {
    return set(TextField::setVisible, visible);
  }

  default TextFieldMixin setReadOnly(boolean readOnly) {
    return set(TextField::setReadOnly, readOnly);
  }

  default TextFieldMixin setEnabled(boolean enabled) {
    return set(TextField::setEnabled, enabled);
  }

  default TextFieldMixin setClassName(String className) {
    return set(TextField::setClassName, className);
  }

  default TextFieldMixin setClassName(String className, boolean set) {
    component().ifPresent(c -> c.setClassName(className, set));
    return this;
  }

  default TextFieldMixin setTabIndex(int tabIndex) {
    return set(TextField::setTabIndex, tabIndex);
  }

  default TextFieldMixin setWidth(String width) {
    return set(TextField::setWidth, width);
  }

  default TextFieldMixin setHeight(String height) {
    return set(TextField::setHeight, height);
  }

  default TextFieldMixin setSizeFull() {
    component().ifPresent(HasSize::setSizeFull);
    return this;
  }

  default TextFieldMixin setSizeUndefined() {
    component().ifPresent(HasSize::setSizeUndefined);
    return this;
  }

  default TextFieldMixin setPrefixComponent(Component component) {
    return set(TextField::setPrefixComponent, component);
  }

  default TextFieldMixin setSuffixComponent(Component component) {
    return set(TextField::setSuffixComponent, component);
  }

  default TextFieldMixin setAutocomplete(Autocomplete autocomplete) {
    return set(TextField::setAutocomplete, autocomplete);
  }

  default TextFieldMixin setAutocapitalize(Autocapitalize autocapitalize) {
    return set(TextField::setAutocapitalize, autocapitalize);
  }

  default TextFieldMixin setAutocorrect(boolean autocorrect) {
    return set(TextField::setAutocorrect, autocorrect);
  }
}
