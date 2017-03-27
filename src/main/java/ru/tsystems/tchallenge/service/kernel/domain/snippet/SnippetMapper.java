package ru.tsystems.tchallenge.service.kernel.domain.snippet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.tchallenge.service.kernel.domain.shared.Mapper;

@Service
@Transactional(readOnly = true)
public class SnippetMapper extends Mapper {

    public SnippetInfo intoSnippetInfo(Snippet snippet) {
        SnippetInfo snippetInfo = new SnippetInfo();
        snippetInfo.setLineup(snippet.getLineup());
        snippetInfo.setContent(snippet.getContent());
        snippetInfo.setStyle(snippet.getStyle());
        return snippetInfo;
    }
}
