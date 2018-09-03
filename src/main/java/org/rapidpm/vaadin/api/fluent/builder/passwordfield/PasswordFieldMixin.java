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
package org.rapidpm.vaadin.api.fluent.builder.passwordfield;

import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.rapidpm.vaadin.api.fluent.builder.component.ComponentMixin;

public interface PasswordFieldMixin extends ComponentMixin<PasswordField> {

  //for typing
  default <V> PasswordFieldMixin set(Setter<PasswordField, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }

  //delegating
  default PasswordFieldMixin setId(String value) {
    return set(PasswordField::setId, value);
  }

  default PasswordFieldMixin setVisible(boolean value) {
    return set(PasswordField::setVisible, value);
  }

  default PasswordFieldMixin setPreventInvalidInput(Boolean value) {
    return set(PasswordField::setPreventInvalidInput, value);
  }

  default PasswordFieldMixin setValueChangeMode(ValueChangeMode valueChangeMode) {
    return set(PasswordField::setValueChangeMode, valueChangeMode);
  }

  default PasswordFieldMixin setErrorMessage(String errorMessage) {
    return set(PasswordField::setErrorMessage, errorMessage);
  }

  default PasswordFieldMixin setInvalid(boolean invalid) {
    return set(PasswordField::setInvalid, invalid);
  }

  default PasswordFieldMixin setLabel(String label) {
    return set(PasswordField::setLabel, label);
  }

  default PasswordFieldMixin setPlaceholder(String placeholder) {
    return set(PasswordField::setPlaceholder, placeholder);
  }

  default PasswordFieldMixin setAutofocus(boolean autofocus) {
    return set(PasswordField::setAutofocus, autofocus);
  }

  default PasswordFieldMixin setMaxLength(int maxLength) {
    return set(PasswordField::setMaxLength, maxLength);
  }

  default PasswordFieldMixin setMinLength(int minLength) {
    return set(PasswordField::setMinLength, minLength);
  }

  default PasswordFieldMixin setRequired(boolean required) {
    return set(PasswordField::setRequired, required);
  }

  default PasswordFieldMixin setPreventInvalidInput(boolean preventInvalidInput) {
    return set(PasswordField::setPreventInvalidInput, preventInvalidInput);
  }

  default PasswordFieldMixin setPattern(String pattern) {
    return set(PasswordField::setPattern, pattern);
  }

  default PasswordFieldMixin setTitle(String title) {
    return set(PasswordField::setTitle, title);
  }

  default PasswordFieldMixin setRevealButtonVisible(boolean revealButtonVisible) {
    return set(PasswordField::setRevealButtonVisible, revealButtonVisible);
  }

  default PasswordFieldMixin setValue(String value) {
    return set(PasswordField::setValue, value);
  }

  default PasswordFieldMixin setRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
    return set(PasswordField::setRequiredIndicatorVisible, requiredIndicatorVisible);
  }
}
