package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByEmail(String email);

    Candidate findByLogin(String login);
}
