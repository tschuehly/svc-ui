package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;

public interface ContentComponent {

  <T> Boolean canHandle(Content content, @Nullable T data);

  <T> ViewContext render(Content content, RenderFunction renderFunction,@Nullable T data);
}
