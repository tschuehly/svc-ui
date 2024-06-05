package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.svc.ui.strategy.Content;
import java.util.Arrays;
import java.util.List;

public class Box<D> implements Content<D> {

  public final List<Content<? super D>> boxContents;
  public Box(List<Content<? super D>> boxContents) {
    this.boxContents = boxContents;
  }

  public Box(Content<? super D>... contents){
    this(Arrays.stream(contents).toList());
  }
}
