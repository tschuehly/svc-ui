package de.tschuehly.svc.ui.content.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContentStrategy {
  private final List<ContentComponent> contentComponentList;

  public ContentStrategy(List<ContentComponent> contentComponentList) {
    this.contentComponentList = contentComponentList;
  }


  public ViewContext render(Content content) {
    ContentComponent contentComponent = contentComponentList.stream()
        .filter(it -> it.canHandle(content))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
    return contentComponent.render(content, this::render);
  }
}
