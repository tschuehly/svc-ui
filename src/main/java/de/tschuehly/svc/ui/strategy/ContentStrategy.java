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

  public <C extends Content<D>, D> ViewContext renderWithData(C content, @Nullable D data) {
    ContentComponent<C, D> contentComponent = getComponent(content, data).orElseThrow(
        () -> new RuntimeException("FormNotImplementedException"));

    return contentComponent.render(content, this::renderWithData, data);
//    ContentComponent<?> contentComponent = contentComponents.stream()
//        .filter(it -> it.canHandle(content))
//        .findFirst()
//        .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
//    ContentComponent<T> ct = (ContentComponent<T>) contentComponent;
//    return ct.render(content, this::renderWithData, data);
  }

  private <C extends Content<D>, D> Optional<ContentComponent<C, D>> getComponent(C content, @Nullable D data) {
    Optional<ContentComponent<C, D>> component = Optional.empty();

    if (data != null) {
      ResolvableType contentComponentType = ResolvableType.forClassWithGenerics(ContentComponent.class,
          ResolvableType.forInstance(content), ResolvableType.forInstance(data));
      component = applicationContext.getBeanProvider(contentComponentType)
          .stream()
          .map(it -> (ContentComponent<C, D>) it)
          .findFirst();
    }
    if (component.isEmpty()) {
      ResolvableType contentComponentType = ResolvableType.forClassWithGenerics(ContentComponent.class,
          ResolvableType.forInstance(content), ResolvableType.forClass(Object.class));
      return applicationContext.getBeanProvider(contentComponentType)
          .stream().map(it -> (ContentComponent<C, D>) it)
          .findFirst();
    }
    return component;
  }


  public ViewContext render(Content<Object> content) {
    return renderWithData(content, null);
  }

  public ContentStrategy(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }
}
