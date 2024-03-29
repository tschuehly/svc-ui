package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.TaskService;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.domain.task.details.TaskDetails;
import de.tschuehly.svc.ui.domain.task.row.TaskRow;
import de.tschuehly.svc.ui.layout.box.Box;
import de.tschuehly.svc.ui.strategy.ContentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

  @Autowired
  private ContentStrategy contentStrategy;
  @Autowired
  private TaskService taskService;

  @GetMapping("/{taskId}")
  ViewContext index(@PathVariable Integer taskId) {
    return contentStrategy.renderWithData(
        new Box<>(
            new TaskDetails(),
            new TaskRow()
        ),
        new Task(1L,"Hello World")
    );
  }
  @GetMapping("/task-error/{taskId}")
  ViewContext taskError(@PathVariable Integer taskId) {
//    This compiler error shows the complie time type safety
    return contentStrategy.renderWithData(
        new Box<>(
            new TaskDetails(),
            new TaskRow()
        ),
//        new Task(1L,"Hello World")
        new User("Hello World")
    );
  }

  @GetMapping("/task-user/{taskId}")
  ViewContext taskUser(@PathVariable Integer taskId) {
// raw types still let you ignore the type bounds
    return contentStrategy.renderWithData(
        new Box(
            new TaskDetails(),
            new TaskRow()
        ),
        new User("Hello World")
    );
  }
  private record User(String hello) {

  }
}
