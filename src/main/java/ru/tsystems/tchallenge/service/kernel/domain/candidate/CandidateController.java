package ru.tsystems.tchallenge.service.kernel.domain.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/data/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(path = "/{login}", method = RequestMethod.GET)
    public CandidateInfo getByLogin(@PathVariable("login") String login) {
        return candidateService.getByLogin(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CandidateInfo create(@RequestBody CandidateProperties candidateProperties) {
        return candidateService.create(candidateProperties);
    }
}
