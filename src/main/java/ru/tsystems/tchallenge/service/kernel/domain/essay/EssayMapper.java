package ru.tsystems.tchallenge.service.kernel.domain.essay;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EssayMapper {

    public Essay intoEssay(EssayProperties essayProperties) {
        Essay essay = new Essay();
        essay.setBitbucket(essayProperties.getBitbucket());
        essay.setFirstname(essayProperties.getFirstname());
        essay.setGithub(essayProperties.getGithub());
        essay.setLastname(essayProperties.getLastname());
        essay.setLinkedin(essayProperties.getLinkedin());
        essay.setPortfolio(essayProperties.getPortfolio());
        essay.setWebsite(essayProperties.getWebsite());
        return essay;
    }

    public EssayProperties intoInfo(Essay essay) {
        EssayProperties essayInfo = new EssayProperties();
        essayInfo.setBitbucket(essay.getBitbucket());
        essayInfo.setFirstname(essay.getFirstname());
        essayInfo.setGithub(essay.getGithub());
        essayInfo.setLastname(essay.getLastname());
        essayInfo.setLinkedin(essay.getLinkedin());
        essayInfo.setPortfolio(essay.getPortfolio());
        essayInfo.setWebsite(essay.getWebsite());
        return essayInfo;
    }
}
