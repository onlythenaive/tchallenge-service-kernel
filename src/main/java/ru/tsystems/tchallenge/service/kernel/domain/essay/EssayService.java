package ru.tsystems.tchallenge.service.kernel.domain.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.Candidate;
import ru.tsystems.tchallenge.service.kernel.domain.candidate.CandidateRepository;

@Service
@Transactional
public class EssayService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private EssayMapper essayMapper;

    public EssayProperties update(EssayProperties essayProperties) {
        Essay essay = essayMapper.intoEssay(essayProperties);
        Candidate candidate = candidateRepository.findByEmail(essayProperties.getEmail());
        candidate.setEssay(essay);
        candidateRepository.save(candidate);
        return essayMapper.intoInfo(essay);
    }
}
