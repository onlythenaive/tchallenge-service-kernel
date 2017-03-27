package ru.tsystems.tchallenge.service.kernel.domain.resolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.utility.mail.MailProperties;
import ru.tsystems.tchallenge.service.kernel.utility.mail.MailService;

@Service
@Transactional
public class ResolutionService {

    @Autowired
    private ResolutionRepository resolutionRepository;

    @Autowired
    private ResolutionMapper resolutionMapper;

//    @Autowired
    private MailService mailService;

    public ResolutionInfo getById(String id) {
        return resolutionMapper.intoResolutionInfo(resolutionRepository.findOne(id));
    }

    public ResolutionInfo create(ResolutionProperties resolutionProperties) {
        Resolution resolution = resolutionMapper.intoResolution(resolutionProperties);
        resolutionRepository.save(resolution);
        ResolutionInfo resolutionInfo = resolutionMapper.intoResolutionInfo(resolution);
        //mailResolutionInfo(resolutionInfo);
        return resolutionInfo;
    }

    private void mailResolutionInfo(ResolutionInfo resolutionInfo) {
        MailProperties mailProperties = new MailProperties();
        mailProperties.setTarget(resolutionInfo.getAdmission().getEmail());
        mailProperties.setSubject(resolutionInfo.getAdmission().getForum() + ": Ваша заявка принята");
        mailProperties.setContent("http://localhost:3000/data/resolutions/" + resolutionInfo.getId());
        mailService.send(mailProperties);
    }
}
