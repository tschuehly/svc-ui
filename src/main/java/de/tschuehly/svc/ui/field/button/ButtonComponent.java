package de.tschuehly.svc.ui.field.button;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.field.FieldComponent;
import de.tschuehly.svc.ui.field.FieldType;

@ViewComponent
public class ButtonComponent implements FieldComponent {

  @Override
  public Boolean canHandle(FieldType fieldType) {
    return FieldType.BUTTON.equals(fieldType);
  }

  @Override
  public ViewContext render(Content content) {
    return new ButtonContext((Button) content);
  }

  public record ButtonContext(Button button) implements ViewContext {

  }
}
