package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class BoxComponent implements ContentComponent {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof Box;
  }

  @Override
  public ViewContext render(Content content, RenderFunction renderFunction, @Nullable Object data) {
    return new BoxContext((Box) content, renderFunction, data);
  }

  public record BoxContext(Box content, RenderFunction renderFunction, Object data) implements ViewContext {

  }
}
