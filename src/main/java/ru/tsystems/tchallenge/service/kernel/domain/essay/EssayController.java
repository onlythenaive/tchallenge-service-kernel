package ru.tsystems.tchallenge.service.kernel.domain.essay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/essays")
public class EssayController {

    @Autowired
    private EssayService essayService;

    @RequestMapping(method = RequestMethod.PUT)
    public EssayProperties update(@RequestBody EssayProperties essayProperties) {
        return essayService.update(essayProperties);
    }
}
