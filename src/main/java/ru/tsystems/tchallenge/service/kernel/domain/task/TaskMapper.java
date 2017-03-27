package ru.tsystems.tchallenge.service.kernel.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;
import ru.tsystems.tchallenge.service.kernel.domain.snippet.Snippet;
import ru.tsystems.tchallenge.service.kernel.domain.snippet.SnippetInfo;
import ru.tsystems.tchallenge.service.kernel.domain.snippet.SnippetMapper;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOption;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOptionInfo;
import ru.tsystems.tchallenge.service.kernel.domain.solution.SolutionOptionMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TaskMapper extends Mapper {

    @Autowired
    private SolutionOptionMapper solutionOptionMapper;

    @Autowired
    private SnippetMapper snippetMapper;

    public TaskInfo intoTaskInfo(Task task) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTitle(task.getTitle());
        taskInfo.setIntroduction(task.getIntroduction());
        taskInfo.setQuestion(task.getQuestion());
        taskInfo.setCategories(new ArrayList<>());
        taskInfo.setComplexity(task.getComplexity());
        taskInfo.setDifficulty(task.getDifficulty().getId());
        taskInfo.setExpectation(task.getExpectation().getId());
        taskInfo.setSnippets(snippets(task.getSnippets()));
        taskInfo.setSolutionOptions(options(task.getSolutionOptions()));
        return taskInfo;
    }

    private Collection<SnippetInfo> snippets(Collection<Snippet> snippet) {
        return snippet
                .stream()
                .map(snippetMapper::intoSnippetInfo)
                .collect(Collectors.toList());
    }

    private Collection<SolutionOptionInfo> options(Collection<SolutionOption> options) {
        return options
                .stream()
                .map(solutionOptionMapper::intoSolutionOptionInfo)
                .collect(Collectors.toList());
    }
}
