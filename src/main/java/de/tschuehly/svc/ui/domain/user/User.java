package de.tschuehly.svc.ui.domain.user;

import de.tschuehly.svc.ui.strategy.Anything;

public record User(Long id, String name) implements Anything {

}
