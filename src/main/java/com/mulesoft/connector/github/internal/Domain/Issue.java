package com.mulesoft.connector.github.internal.Domain;

public class Issue {
    private String milestone;
    private String state;
    private String assignee;
    private String creator;
    private String mentioned;
    private String labels;
    private String sort;
    private String direction;
    private String since;
    private Integer per_page;
    private Integer page;

    public Issue(String milestone, String state, String assignee, String creator, String mentioned, String labels, String sort, String direction, String since, Integer per_page, Integer page) {
        this.milestone = milestone;
        this.state = state;
        this.assignee = assignee;
        this.creator = creator;
        this.mentioned = mentioned;
        this.labels = labels;
        this.sort = sort;
        this.direction = direction;
        this.since = since;
        this.per_page = per_page;
        this.page = page;
    }
}
