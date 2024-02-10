package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

@FunctionalInterface
public interface RenderFunction {
  ViewContext render(Content content);
}
