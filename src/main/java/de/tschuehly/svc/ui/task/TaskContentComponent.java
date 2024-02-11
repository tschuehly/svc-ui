package de.tschuehly.svc.ui.task;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

public interface TaskContentComponent extends ContentComponent {

  @Override
  <T> Boolean canHandle(Content content, @Nullable T data);

  @Override
  <T> ViewContext render(Content content, RenderFunction renderFunction, @Nullable T data);
}
