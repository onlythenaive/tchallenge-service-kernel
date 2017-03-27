package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import ru.tsystems.tchallenge.service.kernel.domain.assignment.AssignmentInfo;

import java.util.Collection;

public class WorkbookInfo {

    private Long id;
    private Collection<AssignmentInfo> assignments;
    private String status;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<AssignmentInfo> getAssignments() {
        return assignments;
    }

    public void setAssignments(Collection<AssignmentInfo> assignments) {
        this.assignments = assignments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
