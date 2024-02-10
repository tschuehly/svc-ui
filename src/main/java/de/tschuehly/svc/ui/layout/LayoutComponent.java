package de.tschuehly.svc.ui.layout;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.RenderFunction;

public interface LayoutComponent {
  Boolean canHandle(LayoutDefinition layoutDefinition);
  ViewContext render(LayoutDefinition layoutDefinition, RenderFunction renderFunction);


}
