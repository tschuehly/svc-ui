package de.tschuehly.svc.ui.content.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.content.strategy.ContentComponent;
import de.tschuehly.svc.ui.content.strategy.RenderFunction;

@ViewComponent
public class BoxComponent implements ContentComponent {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof Box;
  }

  @Override
  public ViewContext render(Content content, RenderFunction renderFunction) {
    return new BoxContext((Box) content, renderFunction);
  }

  public record BoxContext(Box content, RenderFunction renderFunction) implements ViewContext {

  }
}
