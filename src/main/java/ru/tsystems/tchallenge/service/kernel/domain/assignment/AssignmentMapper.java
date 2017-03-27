package ru.tsystems.tchallenge.service.kernel.domain.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;
import ru.tsystems.tchallenge.service.kernel.domain.task.TaskMapper;

@Service
@Transactional(readOnly = true)
public class AssignmentMapper extends Mapper {

    @Autowired
    private TaskMapper taskMapper;

    public AssignmentInfo intoAssignmentInfo(Assignment assignment) {
        AssignmentInfo assignmentInfo = new AssignmentInfo();
        assignmentInfo.setLineup(assignment.getLineup());
        assignmentInfo.setTask(taskMapper.intoTaskInfo(assignment.getTask()));
        return assignmentInfo;
    }
}
