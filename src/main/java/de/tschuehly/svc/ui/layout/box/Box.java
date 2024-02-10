package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.svc.ui.layout.LayoutDefinition;
import de.tschuehly.svc.ui.strategy.Content;
import java.util.Arrays;
import java.util.List;

public class Box implements LayoutDefinition {

  public final List<Content> boxContents;
  public Box(List<Content> boxContents) {
    this.boxContents = boxContents;
  }

  public Box(Content... contents){
    this(Arrays.stream(contents).toList());
  }
}
