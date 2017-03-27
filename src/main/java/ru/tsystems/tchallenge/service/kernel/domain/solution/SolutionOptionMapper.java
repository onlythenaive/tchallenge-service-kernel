package ru.tsystems.tchallenge.service.kernel.domain.solution;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;

@Service
@Transactional(readOnly = true)
public class SolutionOptionMapper extends Mapper {

    public SolutionOptionInfo intoSolutionOptionInfo(SolutionOption solutionOption) {
        SolutionOptionInfo solutionOptionInfo = new SolutionOptionInfo();
        solutionOptionInfo.setTextcode(solutionOption.getTextcode());
        solutionOptionInfo.setContent(solutionOption.getContent());
        return solutionOptionInfo;
    }
}
