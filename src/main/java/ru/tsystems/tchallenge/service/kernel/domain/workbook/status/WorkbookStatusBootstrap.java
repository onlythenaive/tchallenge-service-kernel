package ru.tsystems.tchallenge.service.kernel.domain.workbook.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class WorkbookStatusBootstrap {

    @Autowired
    private WorkbookStatusRepository workbookStatusRepository;

    @PostConstruct
    public void init() {
        workbookStatusRepository.save(status("CREATED", "Создана"));
        workbookStatusRepository.save(status("SUBMITTED", "Отправлена на проверку"));
        workbookStatusRepository.save(status("DISPOSED", "Отклонена"));
        workbookStatusRepository.save(status("ASSESSED", "Проверена"));
    }

    private WorkbookStatus status(String id, String title) {
        WorkbookStatus status = new WorkbookStatus();
        status.setId(id);
        status.setTitle(title);
        return status;
    }
}
