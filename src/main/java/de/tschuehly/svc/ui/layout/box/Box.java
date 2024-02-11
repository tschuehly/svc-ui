package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.svc.ui.strategy.Content;
import java.util.Arrays;
import java.util.List;

public class Box<T> implements Content<T> {

  public final List<Content<T>> boxContents;
  public Box(List<Content<T>> boxContents) {
    this.boxContents = boxContents;
  }

  public Box(Content<T>... contents){
    this(Arrays.stream(contents).toList());
  }
}
