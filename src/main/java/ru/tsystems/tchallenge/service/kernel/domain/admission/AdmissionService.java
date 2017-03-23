package ru.tsystems.tchallenge.service.kernel.domain.admission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.forum.ForumRepository;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationRepository;

@Service
@Transactional
public class AdmissionService {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private MaturityRepository maturityRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    public AdmissionInfo create(AdmissionRequest admissionRequest) {
        Admission admission = new Admission();
        admission.setEmail(admissionRequest.getEmail());
        admission.setShortname(admissionRequest.getShortname());
        admission.setForum(forumRepository.findByTextcode(admissionRequest.getForum()));
        admission.setMaturity(maturityRepository.findOne(admissionRequest.getMaturity()));
        admission.setSpecialization(specializationRepository.findOne(admissionRequest.getSpecialization()));
        admissionRepository.save(admission);
        return info(admission);
    }

    private AdmissionInfo info(Admission admission) {
        AdmissionInfo admissionInfo = new AdmissionInfo();
        admissionInfo.setId(admission.getId());
        admissionInfo.setCreatedAt(admission.getCreatedAt());
        admissionInfo.setShortname(admission.getShortname());
        return admissionInfo;
    }
}
