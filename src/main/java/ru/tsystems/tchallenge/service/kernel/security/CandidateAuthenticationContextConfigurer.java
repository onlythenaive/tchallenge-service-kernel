package ru.tsystems.tchallenge.service.kernel.security;

public interface CandidateAuthenticationContextConfigurer extends CandidateAuthenticationContext {

    void setAuthentication(CandidateAuthentication authentication);
}
