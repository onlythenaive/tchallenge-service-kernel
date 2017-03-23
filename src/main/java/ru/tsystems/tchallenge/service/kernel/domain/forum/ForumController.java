package ru.tsystems.tchallenge.service.kernel.domain.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/forums")
public class ForumController {

    @Autowired
    private ForumRepository forumRepository;

    @RequestMapping(path = "/{textcode}", method = RequestMethod.GET)
    public Forum getByTextcode(@PathVariable("textcode") String textcode) {
        return forumRepository.findByTextcode(textcode);
    }
}
