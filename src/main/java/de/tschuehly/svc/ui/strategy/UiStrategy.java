package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UIStrategy {

  private final List<ContentComponent> contentComponents;

  public UIStrategy(List<ContentComponent> contentComponents) {
    this.contentComponents = contentComponents;
  }


  public <T> ViewContext renderWithData(Content content, @Nullable T data) {
    ContentComponent contentComponent = contentComponents.stream()
        .filter(it -> it.canHandle(content, data))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
    return contentComponent.render(content, this::renderWithData, data);
  }

  public ViewContext render(Content content) {
    return renderWithData(content, null);
  }
}
