package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

public interface ContentComponent {

  Boolean canHandle(Content content);

  ViewContext render(Content content, RenderFunction renderFunction);
}
