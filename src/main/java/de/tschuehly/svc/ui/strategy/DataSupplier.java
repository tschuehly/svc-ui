package de.tschuehly.svc.ui.strategy;

public record DataSupplier<T>(Class<T> type, T object) {
}
