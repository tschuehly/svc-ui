package de.tschuehly.svc.ui.domain.user.details;

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import de.tschuehly.svc.ui.domain.user.User;
import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.ContentComponent;
import de.tschuehly.svc.ui.strategy.RenderFunction;
import org.jetbrains.annotations.Nullable;

@ViewComponent
public class UserDetailsComponent implements ContentComponent<User> {

  @Override
  public Boolean canHandle(Content<User> content) {
    return content instanceof UserDetails;
  }

  @Override
  public ViewContext render(Content<User> content, RenderFunction<User> renderFunction, @Nullable User data) {
    return new UserDetailsContext(data);
  }

  public record UserDetailsContext(User user) implements ViewContext {

  }
}
