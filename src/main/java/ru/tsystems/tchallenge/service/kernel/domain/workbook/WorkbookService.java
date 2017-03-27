package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.admission.Admission;
import ru.tsystems.tchallenge.service.kernel.domain.assignment.Assignment;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateRepository;
import ru.tsystems.tchallenge.service.kernel.domain.resolution.Resolution;
import ru.tsystems.tchallenge.service.kernel.domain.resolution.ResolutionRepository;
import ru.tsystems.tchallenge.service.kernel.domain.task.Task;
import ru.tsystems.tchallenge.service.kernel.domain.task.TaskRepository;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatus;
import ru.tsystems.tchallenge.service.kernel.domain.workbook.status.WorkbookStatusRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service
@Transactional
public class WorkbookService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ResolutionRepository resolutionRepository;

    @Autowired
    private WorkbookStatusRepository workbookStatusRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private WorkbookMapper workbookMapper;

    public WorkbookInfo getById(Long id) {
        return workbookMapper.intoWorkbookInfo(workbookRepository.findOne(id));
    }

    public WorkbookInfo create(WorkbookProperties workbookProperties) {
        Resolution resolution = resolutionRepository.findOne(workbookProperties.getResolution());
        Admission admission = resolution.getAdmission();
        String email = admission.getEmail();
        Candidate candidate = candidateRepository.findByEmail(email);
        Workbook workbook = new Workbook();
        workbook.setStatus(workbookStatusRepository.findOne("CREATED"));
        Collection<Task> tasks = taskRepository.findAll();
        Collection<Assignment> assignments = new ArrayList<>();
        long lineup = 1;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Assignment assignment = new Assignment();
            assignment.setLineup(++lineup);
            assignment.setTask(iterator.next());
            assignment.setWorkbook(workbook);
            assignments.add(assignment);
        }
        workbook.getAssignments().addAll(assignments);
        workbook.setCandidate(candidate);
        workbook.setForum(admission.getForum());
        workbook.setMaturity(admission.getMaturity());
        workbook.setSpecialization(admission.getSpecialization());
        workbookRepository.save(workbook);
        return workbookMapper.intoWorkbookInfo(workbook);
    }

    public WorkbookInfo submit(Long id, WorkbookSubmissionProperties workbookSubmissionProperties) {
        Workbook workbook = workbookRepository.findOne(id);
        workbook.setStatus(workbookStatusRepository.findOne("SUBMITTED"));
        // ...
        workbookRepository.save(workbook);
        return workbookMapper.intoWorkbookInfo(workbook);
    }

    public WorkbookInfo dispose(Long id) {
        Workbook workbook = workbookRepository.findOne(id);
        workbook.setStatus(workbookStatusRepository.findOne("DISPOSED"));
        workbookRepository.save(workbook);
        return workbookMapper.intoWorkbookInfo(workbook);
    }
}
