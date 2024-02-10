package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

public interface DataContentComponent {

  Boolean canHandle(Content content, DataSupplier<?> dataSupplier);

  ViewContext render(Content content, DataRenderFunction renderFunction, DataSupplier<?> dataSupplier);
}
