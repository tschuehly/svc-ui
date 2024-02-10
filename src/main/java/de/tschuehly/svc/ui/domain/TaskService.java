package de.tschuehly.svc.ui.domain;

import de.tschuehly.svc.ui.strategy.DataSupplier;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private Map<Integer, Task> taskHashMap = Map.of(1, new Task("Hello World"));

  public Task getTaskById(Integer id) {
    return taskHashMap.get(id);
  }
}
