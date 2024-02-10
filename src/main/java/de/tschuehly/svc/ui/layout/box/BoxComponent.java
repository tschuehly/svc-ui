package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;

@ViewComponent
public class BoxComponent implements ContentComponent {


  @Override
  public <T> Boolean canHandle(Content content, T data) {
    return content instanceof Box;
  }

  @Override
  public <T> ViewContext render(Content content, RenderFunction renderFunction, T data) {
    return new BoxContext<>((Box) content, renderFunction, data);
  }

  public record BoxContext<T>(Box content, RenderFunction renderFunction, T data) implements ViewContext {

  }
}
