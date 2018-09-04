package org.rapidpm.vaadin.api.fluent.builder.component;

import java.util.Optional;

public interface NeutralMixin<T> {


  Optional<T> component();

  default T build() {
    return component().get();
  }

}
