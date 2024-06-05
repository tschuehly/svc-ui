package de.tschuehly.svc.ui.domain.user.details;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.user.User;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class UserDetailsComponent extends ContentComponent<UserDetails, User> {
  @Override
  protected ViewContext render(UserDetails content, RenderFunction<Content<? super User>, User> renderFunction,
      @Nullable User data) {
    return new UserDetailsContext(data);
  }

  public record UserDetailsContext(User user) implements ViewContext {

  }
}
