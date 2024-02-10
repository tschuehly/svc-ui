package de.tschuehly.svc.ui.field;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;

public interface FieldComponent {
  Boolean canHandle(FieldType fieldType);
  ViewContext render(Content content);

}
