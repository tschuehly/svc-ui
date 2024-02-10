package de.tschuehly.svc.ui.task.row;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.Task;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class TaskRowComponent implements ContentComponent {
  @Override
  public <T> Boolean canHandle(Content content, T data) {
    return content instanceof TaskRow && data instanceof Task;
  }

  @Override
  public <T> ViewContext render(Content content, RenderFunction renderFunction, @Nullable T data) {
    Task task = (Task) data;
    return new TaskRowContext(task);
  }

  public record TaskRowContext(Task task) implements ViewContext {

  }
}
