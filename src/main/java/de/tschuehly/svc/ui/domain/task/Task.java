package de.tschuehly.svc.ui.domain.task;

import de.tschuehly.svc.ui.strategy.Anything;

public record Task(Long id, String name) implements Anything {

}
