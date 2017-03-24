package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateMapper candidateMapper;

    public CandidateInfo getByEmail(String email) {
        return candidateMapper.intoCandidateInfo(candidateRepository.findByEmail(email));
    }

    public CandidateInfo getByLogin(String login) {
        return candidateMapper.intoCandidateInfo(candidateRepository.findByLogin(login));
    }

    public CandidateInfo create(CandidateProperties candidateProperties) {
        Candidate candidate = candidateMapper.intoCandidate(candidateProperties);
        candidateRepository.save(candidate);
        return candidateMapper.intoCandidateInfo(candidate);
    }
}
