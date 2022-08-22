package com.mulesoft.connector.github.internal.Domain;

import java.util.ArrayList;

public class Issue {
    public String url;
    public String repository_url;
    public String labels_url;
    public String comments_url;
    public String events_url;
    public String html_url;
    public int id;
    public String node_id;
    public int number;
    public String title;
    public User user;
    public ArrayList<Object> labels;
    public String state;
    public boolean locked;
    public Object assignee;
    public ArrayList<Object> assignees;
    public Object milestone;
    public int comments;
    public String created_at;
    public String updated_at;
    public String closed_at;
    public String author_association;
    public Object active_lock_reason;
    public String body;
    public Reactions reactions;
    public String timeline_url;
    public Object performed_via_github_app;
    public String state_reason;

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

    public String getRepository_url() {
        return repository_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public int getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Object> getLabels() {
        return labels;
    }

    public String getState() {
        return state;
    }

    public boolean isLocked() {
        return locked;
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

    public int getComments() {
        return comments;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getClosed_at() {
        return closed_at;
    }

    public String getAuthor_association() {
        return author_association;
    }

    public Object getActive_lock_reason() {
        return active_lock_reason;
    }

    public String getBody() {
        return body;
    }

    public Reactions getReactions() {
        return reactions;
    }

    public String getTimeline_url() {
        return timeline_url;
    }

    public Object getPerformed_via_github_app() {
        return performed_via_github_app;
    }

    public String getState_reason() {
        return state_reason;
    }

}