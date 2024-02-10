package de.tschuehly.svc.ui.field.button;

import de.tschuehly.svc.ui.field.FieldDefinition;
import de.tschuehly.svc.ui.field.FieldType;

public class Button extends FieldDefinition {

  public final String label;

  public Button(String label) {
    super(FieldType.BUTTON);
    this.label = label;
  }
}
