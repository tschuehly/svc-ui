package de.tschuehly.svc.ui.layout.box;

import de.tschuehly.svc.ui.strategy.Content;
import java.util.Arrays;
import java.util.List;

public class Box<T> implements Content<T> {

  public final List<Content<? super T>> boxContents;
  public Box(List<Content<? super T>> boxContents) {
    this.boxContents = boxContents;
  }

  public Box(Content<? super T>... contents){
    this(Arrays.stream(contents).toList());
  }
}
