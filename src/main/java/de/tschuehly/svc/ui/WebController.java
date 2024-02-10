package de.tschuehly.svc.ui;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.field.button.Button;
import de.tschuehly.svc.ui.layout.box.Box;
import de.tschuehly.svc.ui.strategy.UIStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
  @Autowired
  private UIStrategy uiStrategy;

  @GetMapping("/")
  ViewContext index(){
    return uiStrategy.render(
        new Box(
            new Button("Hello World"),
            new Button("Hello World2")

        )
    );
  }
}
