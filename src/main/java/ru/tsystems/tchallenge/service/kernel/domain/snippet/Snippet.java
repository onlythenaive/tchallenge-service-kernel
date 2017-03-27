package ru.tsystems.tchallenge.service.kernel.domain.snippet;

import ru.tsystems.tchallenge.service.kernel.domain.shared.Sporadic;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Snippet extends Sporadic {

    @Column
    private Integer lineup;

    @Column
    private String content;

    @Column
    private String style;

    public Integer getLineup() {
        return lineup;
    }

    public void setLineup(Integer lineup) {
        this.lineup = lineup;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
