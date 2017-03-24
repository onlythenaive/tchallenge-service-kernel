package ru.tsystems.tchallenge.service.kernel.security;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class CandidateAuthenticationContextConfigurerBean implements CandidateAuthenticationContextConfigurer {

    private CandidateAuthentication authentication;

    @Override
    public CandidateAuthentication getAuthentication() {
        return authentication;
    }

    @Override
    public void setAuthentication(CandidateAuthentication authentication) {
        this.authentication = authentication;
    }
}
