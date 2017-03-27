package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import ru.tsystems.tchallenge.service.kernel.domain.task.TaskInfo;

public class AssignmentInfo {

    private Long lineup;
    private TaskInfo task;

    public Long getLineup() {
        return lineup;
    }

    public void setLineup(Long lineup) {
        this.lineup = lineup;
    }

    public TaskInfo getTask() {
        return task;
    }

    public void setTask(TaskInfo task) {
        this.task = task;
    }
}
