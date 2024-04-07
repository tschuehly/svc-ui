package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;

public interface ContentComponent<T> {

  Boolean canHandle(Content<T> content);

  ViewContext render(Content<T> content, RenderFunction<T> renderFunction, @Nullable T data);
}
