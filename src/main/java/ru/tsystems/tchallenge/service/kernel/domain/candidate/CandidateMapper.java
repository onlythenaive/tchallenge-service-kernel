package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.resolution.Resolution;
import ru.tsystems.tchallenge.service.kernel.domain.resolution.ResolutionRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;

@Service
@Transactional(readOnly = false)
public class CandidateMapper extends Mapper {

    @Autowired
    private ResolutionRepository resolutionRepository;

    public Candidate intoCandidate(CandidateProperties candidateProperties) {
        Resolution resolution = resolutionRepository.findOne(candidateProperties.getResolution());
        Candidate candidate = new Candidate();
        candidate.setEmail(resolution.getAdmission().getEmail());
        candidate.setLogin(resolution.getAdmission().getEmail());
        return candidate;
    }

    public CandidateInfo intoCandidateInfo(Candidate candidate) {
        CandidateInfo candidateInfo = new CandidateInfo();
        candidateInfo.setEmail(candidate.getEmail());
        candidateInfo.setLogin(candidate.getLogin());
        candidateInfo.setCreatedAt(timestamp(candidate.getCreatedAt()));
        return candidateInfo;
    }
}
