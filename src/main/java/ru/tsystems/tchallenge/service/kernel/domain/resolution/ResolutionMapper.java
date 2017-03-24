package ru.tsystems.tchallenge.service.kernel.domain.resolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tsystems.tchallenge.service.kernel.domain.admission.AdmissionMapper;
import ru.tsystems.tchallenge.service.kernel.domain.admission.AdmissionRepository;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;

@Service
@Transactional(readOnly = true)
public class ResolutionMapper extends Mapper {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private AdmissionMapper admissionMapper;

    public Resolution intoResolution(ResolutionProperties resolutionProperties) {
        Resolution resolution = new Resolution();
        resolution.setAdmission(admissionRepository.findOne(resolutionProperties.getAdmission()));
        return resolution;
    }

    public ResolutionInfo intoResolutionInfo(Resolution resolution) {
        ResolutionInfo resolutionInfo = new ResolutionInfo();
        resolutionInfo.setId(resolution.getId());
        resolutionInfo.setSecret(resolution.getSecret());
        resolutionInfo.setAdmission(admissionMapper.intoAdmissionInfo(resolution.getAdmission()));
        return resolutionInfo;
    }
}
