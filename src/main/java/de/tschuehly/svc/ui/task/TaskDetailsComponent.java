package de.tschuehly.svc.ui.task;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.Task;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.DataContentComponent;
import de.tschuehly.svc.ui.strategy.DataRenderFunction;
import de.tschuehly.svc.ui.strategy.DataSupplier;

@ViewComponent
public class TaskDetailsComponent implements DataContentComponent {

  @Override
  public Boolean canHandle(Content content, DataSupplier<?> dataSupplier) {
    return content instanceof TaskDetails && Task.class == dataSupplier.type();
  }

  @Override
  public ViewContext render(Content content, DataRenderFunction renderFunction, DataSupplier<?> dataSupplier) {
    Task task = (Task) dataSupplier.object();
    return new TaskDetailsContext(task);
  }

  public record TaskDetailsContext(Task task) implements ViewContext {

  }
}
