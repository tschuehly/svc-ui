package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.layout.LayoutComponent;
import de.tschuehly.svc.ui.layout.LayoutDefinition;
import de.tschuehly.svc.ui.strategy.RenderFunction;

@ViewComponent
public class BoxComponent implements LayoutComponent {

  @Override
  public Boolean canHandle(LayoutDefinition layoutDefinition) {
    return layoutDefinition instanceof Box;
  }

  @Override
  public ViewContext render(LayoutDefinition layoutDefinition, RenderFunction renderFunction) {
    return new BoxContext((Box) layoutDefinition, renderFunction);
  }

  public record BoxContext(Box layoutDefinition, RenderFunction renderFunction) implements ViewContext {

  }
}
