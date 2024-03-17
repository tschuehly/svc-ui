package de.tschuehly.svc.ui.content.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

public interface ContentComponent {

  Boolean canHandle(Content content);

  default ViewContext render(Content content, RenderFunction renderFunction){
    return null;
  }
}
