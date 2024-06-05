package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

@FunctionalInterface
public interface RenderFunction<T extends Content<? super S>, S> {
 ViewContext render(T content, S data);
}
