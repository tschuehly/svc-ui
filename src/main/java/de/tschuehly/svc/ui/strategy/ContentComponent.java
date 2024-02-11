package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;

public interface ContentComponent<T> {

  Boolean canHandle(Content content);

  ViewContext render(Content content, RenderFunction<T> renderFunction, @Nullable T data);
}
