package de.tschuehly.svc.ui.domain.task.row;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class TaskRowComponent extends ContentComponent<TaskRow, Task> {

  @Override
  protected ViewContext render(TaskRow content, RenderFunction<Content<? super Task>, Task> renderFunction,
      @Nullable Task data) {
    return new TaskRowContext(data);
  }


  public record TaskRowContext(Task task) implements ViewContext {

  }
}
