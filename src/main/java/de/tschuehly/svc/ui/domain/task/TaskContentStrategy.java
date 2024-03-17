package de.tschuehly.svc.ui.domain.task;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.content.strategy.Content;
import de.tschuehly.svc.ui.content.strategy.ContentComponent;
import de.tschuehly.svc.ui.content.strategy.ContentStrategy;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskContentStrategy {

  private final List<ContentComponent> contentComponentList;
  private final ContentStrategy contentStrategy;

  public TaskContentStrategy(List<ContentComponent> contentComponentList, ContentStrategy contentStrategy) {
    this.contentComponentList = contentComponentList;
    this.contentStrategy = contentStrategy;
  }

  public ViewContext render(Content content, Task task){
    ContentComponent contentComponent = contentComponentList.stream()
        .filter(it -> it.canHandle(content))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
    if (contentComponent instanceof TaskContentComponent taskContentComponent){
      return taskContentComponent.render(content,this::render, task);
    }
    return contentComponent.render(content, contentStrategy::render);
  }
}
