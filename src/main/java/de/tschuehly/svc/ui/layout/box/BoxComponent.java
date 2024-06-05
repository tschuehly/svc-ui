package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import java.util.List;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class BoxComponent<D> extends ContentComponent<Box<D>, D> {

  @Override
  protected ViewContext render(Box<D> content, RenderFunction<Content<? super D>, D> renderFunction, @Nullable D data) {
    List<ViewContext> viewContextList = content.boxContents.stream().map(it -> renderFunction.render(it, data))
        .toList();
    return new BoxContext(viewContextList);
  }

  public record BoxContext(List<ViewContext> viewContextList) implements ViewContext {

  }
}
