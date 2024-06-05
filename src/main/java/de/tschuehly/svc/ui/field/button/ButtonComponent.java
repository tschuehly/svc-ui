package de.tschuehly.svc.ui.field.button;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.strategy.Anything;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class ButtonComponent extends ContentComponent<Button, Object>{

  @Override
  protected ViewContext render(Button content, RenderFunction<Content<? super Object>, Object> renderFunction,
      @Nullable Object data) {
    return new ButtonContext(content);
  }

  public record ButtonContext(Button button) implements ViewContext {}
}
