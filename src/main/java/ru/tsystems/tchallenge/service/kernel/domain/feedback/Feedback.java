package ru.tsystems.tchallenge.service.kernel.domain.feedback;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.Workbook;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Feedback extends Sporadic {

    @OneToOne
    private Workbook workbook;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }
}
