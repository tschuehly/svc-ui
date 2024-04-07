package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.task.Task;
import de.tschuehly.svc.ui.domain.task.details.TaskDetails;
import de.tschuehly.svc.ui.domain.task.row.TaskRow;
import de.tschuehly.svc.ui.domain.user.User;
import de.tschuehly.svc.ui.domain.user.details.UserDetails;
import de.tschuehly.svc.ui.field.button.Button;
import de.tschuehly.svc.ui.layout.box.Box;
import de.tschuehly.svc.ui.strategy.ContentStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

  private final ContentStrategy contentStrategy;

  public WebController(ContentStrategy contentStrategy) {
    this.contentStrategy = contentStrategy;
  }


  @GetMapping("/")
  ViewContext index() {
    return contentStrategy.render(new Box<>(
        new Button("Hello World")
    ));
  }
// We can use only use the Content with the data they specified
  @GetMapping("/user/{userId}")
  ViewContext user(@PathVariable Long userId) {
    return contentStrategy.renderWithData(new Box<>(
            new UserDetails()
        ),
        new User(userId, "Thomas")

//   When Task is passed as data a compiler error shows the compile time type safety
//    new Task(taskId, "Hello World")
    );
  }

  //  We can use Components that use specific data and no data together
  @GetMapping("/task/{taskId}")
  ViewContext task(@PathVariable Long taskId) {
    return contentStrategy.renderWithData(
        new Box<>(
            new TaskDetails(),
            new TaskRow(),
            new Button("new world")
        ),
        new Task(taskId, "Hello World")
    );
  }

  //  We cannot use Components that use different data together
  @GetMapping("/task/{taskId}")
  ViewContext taskUser(@PathVariable Long taskId) {
    return contentStrategy.renderWithData(
        new Box<>(
            new TaskDetails()
//            ,new UserDetails()
        ),
        new Task(taskId, "Hello World")
    );
  }

  @GetMapping("/task-error/{taskId}")
  ViewContext taskError(@PathVariable Long taskId) {
    return contentStrategy.renderWithData(
        new Box<>(
            new TaskDetails()
        ),
        new Task(taskId, "Hello World")
//        new User("Hello World")
    );
  }

}
