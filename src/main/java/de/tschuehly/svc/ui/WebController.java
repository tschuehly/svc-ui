package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.box.Box;
import de.tschuehly.svc.ui.content.button.Button;
import de.tschuehly.svc.ui.content.strategy.ContentStrategy;
import de.tschuehly.svc.ui.domain.TaskService;
import de.tschuehly.svc.ui.domain.task.TaskContentStrategy;
import de.tschuehly.svc.ui.domain.task.details.TaskDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

  private final ContentStrategy contentStrategy;
  private final TaskContentStrategy taskContentStrategy;
  private final TaskService taskService;


  public WebController(ContentStrategy contentStrategy, TaskContentStrategy taskContentStrategy, TaskService taskService) {
    this.contentStrategy = contentStrategy;
    this.taskContentStrategy = taskContentStrategy;
    this.taskService = taskService;
  }

  @GetMapping("/")
  ViewContext index() {
    return contentStrategy.render(
        new Box(
            new Button("Hello World")
        )
    );
  }

   @GetMapping("/task/{taskId}")
  ViewContext task(@PathVariable Integer taskId){
    return taskContentStrategy.render(
        new Box(
            new TaskDetails()
        ),
        taskService.getTaskById(taskId)
    );
   }

}
