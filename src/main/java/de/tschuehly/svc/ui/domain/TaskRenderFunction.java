package de.tschuehly.svc.ui.domain;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.domain.task.Task;

@FunctionalInterface
public interface TaskRenderFunction {
  ViewContext render(Content content, Task task);

}