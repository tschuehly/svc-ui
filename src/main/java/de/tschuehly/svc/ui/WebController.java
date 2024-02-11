package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.TaskService;
import de.tschuehly.svc.ui.layout.box.Box;
import de.tschuehly.svc.ui.strategy.UIStrategy;
import de.tschuehly.svc.ui.task.TaskDetails;
import de.tschuehly.svc.ui.task.row.TaskRow;
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
        new Box(
            new TaskDetails(),
            new TaskRow()
        ),
        taskService.getTaskById(taskId)
    );
  }
}
