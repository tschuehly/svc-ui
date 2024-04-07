package de.tschuehly.svc.ui.field.button;


import de.tschuehly.svc.ui.strategy.Content;
import de.tschuehly.svc.ui.strategy.Anything;

public record Button(String label)  implements Content<Anything> {

}
