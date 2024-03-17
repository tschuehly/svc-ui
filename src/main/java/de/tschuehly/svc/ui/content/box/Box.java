package de.tschuehly.svc.ui.content.box;

import de.tschuehly.svc.ui.content.strategy.Content;
import java.util.Arrays;
import java.util.List;

public class Box implements Content {

  public final List<Content> boxContents;
  public Box(List<Content> boxContents) {
    this.boxContents = boxContents;
  }

  public Box(Content... contents){
    this(Arrays.stream(contents).toList());
  }
}
