package de.tschuehly.svc.ui.field.button;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class ButtonComponent implements ContentComponent<Object> {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof Button;
  }

  @Override
  public ViewContext render(Content content, RenderFunction renderFunction, @Nullable Object data) {
    return new ButtonContext((Button) content);
  }


  public record ButtonContext(Button button) implements ViewContext {}
}
