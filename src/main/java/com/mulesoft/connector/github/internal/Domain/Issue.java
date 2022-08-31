package com.mulesoft.connector.github.internal.Domain;

import java.util.ArrayList;

public class Issue {
    private String url;
    private String repository_url;
    private String labels_url;
    private String comments_url;
    private String events_url;
    private String html_url;
    private int id;
    private String node_id;
    private int number;
    private String title;
    private User user;
    private ArrayList<Object> labels;
    private String state;
    private boolean locked;
    private Object assignee;
    private ArrayList<Object> assignees;
    private Object milestone;
    private int comments;
    private String created_at;
    private String updated_at;
    private String closed_at;
    private String author_association;
    private Object active_lock_reason;
    private String body;
    private Reactions reactions;
    private String timeline_url;
    private Object performed_via_github_app;
    private String state_reason;

    public Issue(String title, String body, Object milestone, ArrayList<Object> labels, ArrayList<Object> assignees) {
        this.title = title;
        this.labels = labels;
        this.assignees = assignees;
        this.milestone = milestone;
        this.body = body;
    }

    public Issue(String url, String repository_url, String labels_url, String comments_url, String events_url, String html_url, int id, String node_id, int number, String title, User user, ArrayList<Object> labels, String state, boolean locked, Object assignee, ArrayList<Object> assignees, Object milestone, int comments, String created_at, String updated_at, String closed_at, String author_association, Object active_lock_reason, String body, Reactions reactions, String timeline_url, Object performed_via_github_app, String state_reason) {
        this.url = url;
        this.repository_url = repository_url;
        this.labels_url = labels_url;
        this.comments_url = comments_url;
        this.events_url = events_url;
        this.html_url = html_url;
        this.id = id;
        this.node_id = node_id;
        this.number = number;
        this.title = title;
        this.user = user;
        this.labels = labels;
        this.state = state;
        this.locked = locked;
        this.assignee = assignee;
        this.assignees = assignees;
        this.milestone = milestone;
        this.comments = comments;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.closed_at = closed_at;
        this.author_association = author_association;
        this.active_lock_reason = active_lock_reason;
        this.body = body;
        this.reactions = reactions;
        this.timeline_url = timeline_url;
        this.performed_via_github_app = performed_via_github_app;
        this.state_reason = state_reason;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Object> getLabels() {
        return labels;
    }

    public Object getAssignee() {
        return assignee;
    }

    public ArrayList<Object> getAssignees() {
        return assignees;
    }

    public Object getMilestone() {
        return milestone;
    }

    public String getBody() {
        return body;
    }
}