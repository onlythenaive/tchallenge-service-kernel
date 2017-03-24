package ru.tsystems.tchallenge.service.kernel.domain.admission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.resolution.ResolutionProperties;
import ru.tsystems.tchallenge.service.kernel.domain.resolution.ResolutionService;
import ru.tsystems.tchallenge.service.kernel.utility.batch.BatchProcessor;

@Service
@Transactional
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private AdmissionMapper admissionMapper;

    @Autowired
    private ResolutionService resolutionService;

    @Autowired
    private BatchProcessor batchProcessor;

    public AdmissionInfo getById(String id) {
        return admissionMapper.intoAdmissionInfo(admissionRepository.findOne(id));
    }

    public AdmissionInfo create(AdmissionProperties admissionProperties) {
        Admission admission = admissionMapper.intoAdmission(admissionProperties);
        admissionRepository.save(admission);
        AdmissionInfo admissionInfo = admissionMapper.intoAdmissionInfo(admission);
        batchCreateResolution(admissionInfo);
        return admissionInfo;
    }

    private void batchCreateResolution(AdmissionInfo admissionInfo) {
        ResolutionProperties resolutionProperties = new ResolutionProperties();
        resolutionProperties.setAdmission(admissionInfo.getId());
        batchProcessor.submit(() -> {
            resolutionService.create(resolutionProperties);
        });
    }
}
