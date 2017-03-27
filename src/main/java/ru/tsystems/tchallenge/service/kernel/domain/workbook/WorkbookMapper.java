package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.AssignmentInfo;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.AssignmentMapper;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class WorkbookMapper extends Mapper {

    @Autowired
    private AssignmentMapper assignmentMapper;

    public WorkbookInfo intoWorkbookInfo(Workbook workbook) {
        WorkbookInfo workbookInfo = new WorkbookInfo();
        workbookInfo.setId(workbook.getId());
        workbookInfo.setAssignments(assignmentInfos(workbook.getAssignments()));
        workbookInfo.setStatus(workbook.getStatus().getId());
        workbookInfo.setCreatedAt(timestamp(workbook.getCreatedAt()));
        return workbookInfo;
    }

    private Collection<AssignmentInfo> assignmentInfos(Collection<Assignment> assignments) {
        return assignments
                .stream()
                .map(assignmentMapper::intoAssignmentInfo)
                .collect(Collectors.toList());
    }
}
