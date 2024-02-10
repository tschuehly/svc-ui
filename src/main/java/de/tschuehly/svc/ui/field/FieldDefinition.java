package de.tschuehly.svc.ui.field;

import de.tschuehly.svc.ui.strategy.Content;

public class FieldDefinition implements Content {
  public final FieldType fieldType;

  public FieldDefinition(FieldType fieldType) {
    this.fieldType = fieldType;
  }
}
