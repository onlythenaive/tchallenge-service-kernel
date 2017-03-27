package ru.tsystems.tchallenge.service.kernel.domain.workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/data/workbooks")
public class WorkbookController {

    @Autowired
    private WorkbookService workbookService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WorkbookInfo getById(@PathVariable("id") Long id) {
        return workbookService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public WorkbookInfo create(@RequestBody WorkbookProperties workbookProperties) {
        return workbookService.create(workbookProperties);
    }

    @RequestMapping(path = "/{id}/submission", method = RequestMethod.POST)
    public WorkbookInfo submit(@PathVariable("id") Long id,
                               @RequestBody WorkbookSubmissionProperties workbookSubmissionProperties) {
        return workbookService.submit(id, workbookSubmissionProperties);
    }

    @RequestMapping(path = "/{id}/disposal", method = RequestMethod.POST)
    public WorkbookInfo dispose(@PathVariable("id") Long id) {
        return workbookService.dispose(id);
    }
}
