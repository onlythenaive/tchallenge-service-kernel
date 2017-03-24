package ru.tsystems.tchallenge.service.kernel.domain.resolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/resolutions")
public class ResolutionController {

    @Autowired
    private ResolutionService resolutionService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResolutionInfo getById(@PathVariable("id") String id) {
        return resolutionService.getById(id);
    }
}
