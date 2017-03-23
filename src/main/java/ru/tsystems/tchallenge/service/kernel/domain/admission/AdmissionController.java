package ru.tsystems.tchallenge.service.kernel.domain.admission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @RequestMapping(method = RequestMethod.POST)
    public AdmissionInfo create(@RequestBody AdmissionRequest admissionRequest) {
        return admissionService.create(admissionRequest);
    }
}
