package de.tschuehly.svc.ui.content.button;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.content.strategy.ContentComponent;
import de.tschuehly.svc.ui.content.strategy.RenderFunction;

@ViewComponent
public class ButtonComponent implements ContentComponent {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof Button;
  }

  @Override
  public ViewContext render(Content content, RenderFunction renderFunction) {
    return new ButtonContext((Button) content);
  }

  public record ButtonContext(Button button) implements ViewContext {}
}
