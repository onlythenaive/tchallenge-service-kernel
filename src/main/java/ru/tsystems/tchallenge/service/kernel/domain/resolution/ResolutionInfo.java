package ru.tsystems.tchallenge.service.kernel.domain.resolution;

import ru.tsystems.tchallenge.service.kernel.domain.admission.AdmissionInfo;

public class ResolutionInfo {

    private String id;
    private String secret;
    private AdmissionInfo admission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public AdmissionInfo getAdmission() {
        return admission;
    }

    public void setAdmission(AdmissionInfo admission) {
        this.admission = admission;
    }
}
