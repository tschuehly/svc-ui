package de.tschuehly.svc.ui.domain.task;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.content.strategy.ContentComponent;
import de.tschuehly.svc.ui.domain.TaskRenderFunction;

public interface TaskContentComponent extends ContentComponent {
  ViewContext render(Content content, TaskRenderFunction renderFunction, Task task);
}
