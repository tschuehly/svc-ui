package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.task.Task;
import jakarta.annotation.Nullable;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContentStrategy {

  private final List<ContentComponent<?>> contentComponents;

  public ContentStrategy(List<ContentComponent<?>> contentComponents) {
    this.contentComponents = contentComponents;
  }


  public <T> ViewContext renderWithData(Content<T> content, @Nullable T data) {
    ContentComponent contentComponent = contentComponents.stream()
        .filter(it -> it.canHandle(content))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
    return contentComponent.render(content, this::renderWithData, data);
  }

  public ViewContext render(Content content) {
    return renderWithData(content, null);
  }
}
