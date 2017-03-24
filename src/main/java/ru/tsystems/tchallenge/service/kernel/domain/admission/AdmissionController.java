package ru.tsystems.tchallenge.service.kernel.domain.admission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/data/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public AdmissionInfo getById(@PathVariable("id") String id) {
        return admissionService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public AdmissionInfo create(@RequestBody AdmissionProperties admissionProperties) {
        return admissionService.create(admissionProperties);
    }
}
