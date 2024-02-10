package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.Task;
import de.tschuehly.svc.ui.domain.TaskService;
import de.tschuehly.svc.ui.field.button.Button;
import de.tschuehly.svc.ui.layout.box.Box;
import de.tschuehly.svc.ui.strategy.DataSupplier;
import de.tschuehly.svc.ui.strategy.UIStrategy;
import de.tschuehly.svc.ui.task.TaskDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

  @Autowired
  private UIStrategy uiStrategy;

  @Autowired
  private TaskService taskService;
  @GetMapping("/{taskId}")
  ViewContext index(@PathVariable Integer taskId) {
    return uiStrategy.renderWithData(
        new TaskDetails(),
        new DataSupplier<>(
            Task.class,
            taskService.getTaskById(taskId)
        )

    );
  }
}
