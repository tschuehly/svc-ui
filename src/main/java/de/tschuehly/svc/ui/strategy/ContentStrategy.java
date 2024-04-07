package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

@Service
public class ContentStrategy {

  private final ApplicationContext applicationContext;

  public <T> ViewContext renderWithData(Content<T> content, @Nullable T data) {
    ContentComponent<T> component = getComponent(content, data).orElseThrow(
        () -> new RuntimeException("FormNotImplementedException"));
    return component.render(content, this::renderWithData, data);
//    ContentComponent<?> contentComponent = contentComponents.stream()
//        .filter(it -> it.canHandle(content))
//        .findFirst()
//        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
//    ContentComponent<T> ct = (ContentComponent<T>) contentComponent;
//    return ct.render(content, this::renderWithData, data);
  }

  private <T> Optional<ContentComponent<T>> getComponent(Content<T> content, @Nullable T data) {
    Optional<ContentComponent<T>> component = Optional.empty();
    if (data != null) {
      component = applicationContext.getBeanProvider(
              ResolvableType.forClassWithGenerics(ContentComponent.class, data.getClass())).stream()
          .map(it -> (ContentComponent<T>) it)
          .filter(it -> it.canHandle(content))
          .findFirst();
    }
    if (component.isEmpty()) {
      return applicationContext.getBeanProvider(
              ResolvableType.forClassWithGenerics(ContentComponent.class, ResolvableType.forClass(Object.class)))
          .stream().map(it -> (ContentComponent<T>) it)
          .filter(it -> it.canHandle(content))
          .findFirst();
    }
    return component;
  }


  public ViewContext render(Content<?> content) {
    return renderWithData(content, null);
  }

  public ContentStrategy(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
}
