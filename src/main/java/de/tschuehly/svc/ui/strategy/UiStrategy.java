package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.field.FieldComponent;
import de.tschuehly.svc.ui.field.FieldDefinition;
import de.tschuehly.svc.ui.layout.LayoutComponent;
import de.tschuehly.svc.ui.layout.LayoutDefinition;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UiStrategy {
  private final List<LayoutComponent> layoutComponents;
  private final List<FieldComponent> fieldComponents;

  public UiStrategy(List<LayoutComponent> layoutComponents, List<FieldComponent> fieldComponents) {
    this.layoutComponents = layoutComponents;
    this.fieldComponents = fieldComponents;
  }

  public ViewContext render(Content content) {
    if(content instanceof FieldDefinition fieldDefinition){
      FieldComponent fieldComponent = fieldComponents.stream()
          .filter(it -> it.canHandle(fieldDefinition.fieldType))
          .findFirst()
          .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
      return fieldComponent.render(fieldDefinition);
    }
    if(content instanceof LayoutDefinition fieldDefinition){
      LayoutComponent layoutComponent = layoutComponents.stream()
          .filter(it -> it.canHandle(fieldDefinition))
          .findFirst()
          .orElseThrow(() -> new RuntimeException("FormNotImplementedException"));
      return layoutComponent.render(fieldDefinition, this::render);
    }
    throw new RuntimeException("InvalidFormException");
  }
}
