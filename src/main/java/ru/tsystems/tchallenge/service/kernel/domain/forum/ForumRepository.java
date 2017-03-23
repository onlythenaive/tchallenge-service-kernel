package ru.tsystems.tchallenge.service.kernel.domain.forum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

    Forum findByTextcode(String textcode);
}
