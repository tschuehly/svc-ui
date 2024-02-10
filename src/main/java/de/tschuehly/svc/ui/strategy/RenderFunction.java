package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

@FunctionalInterface
public interface RenderFunction {
 <T> ViewContext render(Content content, T data);
}
