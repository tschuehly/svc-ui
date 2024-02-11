package de.tschuehly.svc.ui.domain.task.details;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class TaskDetailsComponent implements ContentComponent<Task> {

  @Override
  public Boolean canHandle(Content content) {
    return content instanceof TaskDetails;
  }

  @Override
  public ViewContext render(Content content, RenderFunction<Task> renderFunction, @Nullable Task data) {
    return new TaskDetailsContext(data);
  }


  public record TaskDetailsContext(Task task) implements ViewContext {

  }
}
