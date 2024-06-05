package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;

public abstract class ContentComponent<C extends Content<D>, D> {

  private final Class<?> contentType;

  Boolean canHandle(Content<C> content) {
    if (contentType.isInstance(content)) {
      return true;
    }
    return false;
  }

  public ContentComponent(C... reified) {
    this.contentType = reified.getClass().getComponentType();
  }

  protected abstract ViewContext render(C content, RenderFunction<Content<? super D>, D> renderFunction, @Nullable D data);
}
