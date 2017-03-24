package ru.tsystems.tchallenge.service.kernel.domain.admission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.essay.Essay;
import ru.tsystems.tchallenge.service.kernel.domain.essay.EssayMapper;
import ru.tsystems.tchallenge.service.kernel.domain.essay.EssayProperties;
import ru.tsystems.tchallenge.service.kernel.domain.forum.Forum;
import ru.tsystems.tchallenge.service.kernel.domain.forum.ForumRepository;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.Maturity;
import ru.tsystems.tchallenge.service.kernel.domain.maturity.MaturityRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.Specialization;
import ru.tsystems.tchallenge.service.kernel.domain.specialization.SpecializationRepository;

@Service
@Transactional(readOnly = true)
public class AdmissionMapper extends Mapper {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private MaturityRepository maturityRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private EssayMapper essayMapper;

    public Admission intoAdmission(AdmissionProperties admissionProperties) {
        Admission admission = new Admission();
        admission.setEmail(admissionProperties.getEmail());
        admission.setShortname(admissionProperties.getShortname());
        admission.setForum(forum(admissionProperties.getForum()));
        admission.setMaturity(maturity(admissionProperties.getMaturity()));
        admission.setSpecialization(specialization(admissionProperties.getSpecialization()));
        admission.setEssay(essay(admissionProperties.getEssay()));
        admission.setChallengeRequested(flag(admissionProperties.getChallengeRequested()));
        admission.setEssayProvided(flag(admissionProperties.getEssayProvided()));
        return admission;
    }

    public AdmissionInfo intoAdmissionInfo(Admission admission) {
        AdmissionInfo admissionInfo = new AdmissionInfo();
        admissionInfo.setId(admission.getId());
        admissionInfo.setShortname(admission.getShortname());
        admissionInfo.setEmail(admission.getEmail());
        admissionInfo.setForum(admission.getForum().getTextcode());
        admissionInfo.setChallengeRequested(flag(admission.getChallengeRequested()));
        admissionInfo.setEssayProvided(flag(admission.getEssayProvided()));
        admissionInfo.setCreatedAt(timestamp(admission.getCreatedAt()));
        return admissionInfo;
    }

    private Forum forum(String textcode) {
        return forumRepository.findByTextcode(textcode);
    }

    private Maturity maturity(String id) {
        return maturityRepository.findOne(id);
    }

    private Specialization specialization(String id) {
        return specializationRepository.findOne(id);
    }

    private Essay essay(EssayProperties essayProperties) {
        if (essayProperties == null) {
            return null;
        }
        return essayMapper.intoEssay(essayProperties);
    }
}
