package de.tschuehly.svc.ui.domain;

import de.tschuehly.svc.ui.domain.task.Task;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final Map<Integer, Task> taskHashMap = Map.of(1, new Task(1L,"Hello World"));

  public Task getTaskById(Integer id) {
    return taskHashMap.get(id);
  }
}
