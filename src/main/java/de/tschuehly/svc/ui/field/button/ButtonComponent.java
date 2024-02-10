package de.tschuehly.svc.ui.field.button;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class ButtonComponent implements ContentComponent {

  @Override
  public <T> Boolean canHandle(Content content, T data) {
    return content instanceof Button;
  }

  @Override
  public <T> ViewContext render(Content content, RenderFunction renderFunction, @Nullable T data) {
    return new ButtonContext((Button) content);
  }

  public record ButtonContext(Button button) implements ViewContext {}
}
