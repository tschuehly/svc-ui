package de.tschuehly.svc.ui.domain.task.details;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.domain.TaskRenderFunction;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.domain.task.TaskContentComponent;

@ViewComponent
public class TaskDetailsComponent implements TaskContentComponent {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof TaskDetails;
  }

  @Override
  public ViewContext render(Content content, TaskRenderFunction renderFunction, Task task) {
    return new TaskDetailsContext(task);
  }

  public record TaskDetailsContext(Task task) implements ViewContext {

  }
}
