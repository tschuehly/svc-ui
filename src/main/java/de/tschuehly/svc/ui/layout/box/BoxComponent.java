package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import java.util.List;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class BoxComponent<T> implements ContentComponent<T> {

  @Override
  public Boolean canHandle(Content<T> content) {
    return content instanceof Box;
  }

  @Override
  public ViewContext render(Content<T> content, RenderFunction<T> renderFunction, @Nullable T data) {
    Box<T> box = (Box<T>) content;
    List<ViewContext> viewContextList = box.boxContents.stream().map(it -> renderFunction.render((Content<T>) it, data)).toList();
    return new BoxContext(viewContextList);
  }

  public record BoxContext(List<ViewContext> viewContextList) implements ViewContext {

  }
}
