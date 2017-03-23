package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;
import ru.tsystems.tchallenge.service.kernel.domain.task.Task;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.Workbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Assignment extends Sporadic {

    @ManyToOne
    private Workbook workbook;

    @OneToOne
    private Task task;

    @Column
    private Long lineup;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getLineup() {
        return lineup;
    }

    public void setLineup(Long lineup) {
        this.lineup = lineup;
    }
}
