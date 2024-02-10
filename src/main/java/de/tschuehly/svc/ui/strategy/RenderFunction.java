package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;

@FunctionalInterface
public interface RenderFunction {
  ViewContext render(Content content);
}
