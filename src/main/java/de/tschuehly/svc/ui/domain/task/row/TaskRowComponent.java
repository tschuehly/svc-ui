package de.tschuehly.svc.ui.domain.task.row;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class TaskRowComponent implements ContentComponent<Task> {

  @Override
  public Boolean canHandle(Content<Task> content) {
    return content instanceof TaskRow;
  }

  @Override
  public ViewContext render(Content<Task> content, RenderFunction<Task> renderFunction, @Nullable Task data) {
    return new TaskRowContext(data);
  }


  public record TaskRowContext(Task task) implements ViewContext {

  }
}
