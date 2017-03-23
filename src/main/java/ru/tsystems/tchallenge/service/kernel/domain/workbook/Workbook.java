package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.feedback.Feedback;
import ru.tsystems.tchallenge.service.kernel.domain.forum.Forum;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Sequential;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Workbook extends Sequential {

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Forum forum;

    @ManyToOne
    private Maturity maturity;

    @ManyToOne
    private Specialization specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Assignment> assignments = new ArrayList<>();

    @OneToOne
    private Feedback feedback;

    @ManyToOne
    private WorkbookStatus status;

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Maturity getMaturity() {
        return maturity;
    }

    public void setMaturity(Maturity maturity) {
        this.maturity = maturity;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Collection<Assignment> getAssignments() {
        return assignments;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public WorkbookStatus getStatus() {
        return status;
    }

    public void setStatus(WorkbookStatus status) {
        this.status = status;
    }
}
