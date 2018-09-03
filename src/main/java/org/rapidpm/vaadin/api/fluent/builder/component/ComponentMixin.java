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
package org.rapidpm.vaadin.api.fluent.builder.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.binder.Setter;

import java.util.Optional;

public interface ComponentMixin<T extends Component> {

  Optional<T> component();

  default ComponentMixin<T> setId(String id) {
    component().ifPresent(c -> c.setId(id));
    return this;
  }

  default ComponentMixin<T> setVisible(boolean key) {
    component().ifPresent(c -> c.setVisible(key));
    return this;
  }

  default <V> ComponentMixin<T> set(Setter<T, V> target, V value) {
    component().ifPresent(c -> target.accept(c, value));
    return this;
  }
}
