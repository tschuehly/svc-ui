package de.tschuehly.svc.ui.strategy;

import de.tschuehly.spring.viewcomponent.jte.ViewContext;

@FunctionalInterface
public interface DataRenderFunction {
  ViewContext render(Content content, DataSupplier<?> dataSupplier);

}
