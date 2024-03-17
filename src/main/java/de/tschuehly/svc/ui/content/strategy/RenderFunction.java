package de.tschuehly.svc.ui.content.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

@FunctionalInterface
public interface RenderFunction {
  ViewContext render(Content content);
}
