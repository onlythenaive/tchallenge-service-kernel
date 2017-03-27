package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import ru.tsystems.tchallenge.service.kernel.domain.assignment.AssignmentSubmissionProperties;

import java.util.Collection;

public class WorkbookSubmissionProperties {

    private Collection<AssignmentSubmissionProperties> assignmentSubmissions;

    public Collection<AssignmentSubmissionProperties> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(Collection<AssignmentSubmissionProperties> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }
}
