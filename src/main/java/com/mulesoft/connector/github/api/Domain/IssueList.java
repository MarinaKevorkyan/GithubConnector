package com.mulesoft.connector.github.api.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class IssueList{
    private String url;
    @JsonProperty("repository_url")
    private String repositoryUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("html_url")
    private String htmlUrl;
    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    private int number;
    private String title;
    private User user;
    private ArrayList<String> labels;
    private String state;
    private boolean locked;
    private Object assignee;
    private ArrayList<String> assignees;
    private String milestone;
    private int comments;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private String closedAt;
    @JsonProperty("author_association")
    private String authorAssociation;
    @JsonProperty("active_lock_reason")
    private String activeLockReason;
    private String body;
    private Reactions reactions;
    private String timeline_url;
    @JsonProperty("performed_via_github_app")
    private Object performedViaGithubApp;
    private String state_reason;

    public IssueList() {
    }

    public IssueList(String title, String body, ArrayList<String> labels, ArrayList<String> assignees, String milestone) {
        this.title = title;
        this.labels = labels;
        this.assignees = assignees;
        this.milestone = milestone;
        this.body = body;
    }

    public IssueList(String url, String repositoryUrl, String labelsUrl, String commentsUrl, String eventsUrl, String htmlUrl, int id, String nodeId, int number, String title, User user, ArrayList<String> labels, String state, boolean locked, Object assignee, ArrayList<String> assignees, String milestone, int comments, String createdAt, String updatedAt, String closedAt, String authorAssociation, String activeLockReason, String body, Reactions reactions, String timeline_url, Object performedViaGithubApp, String state_reason) {
        this.url = url;
        this.repositoryUrl = repositoryUrl;
        this.labelsUrl = labelsUrl;
        this.commentsUrl = commentsUrl;
        this.eventsUrl = eventsUrl;
        this.htmlUrl = htmlUrl;
        this.id = id;
        this.nodeId = nodeId;
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
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.authorAssociation = authorAssociation;
        this.activeLockReason = activeLockReason;
        this.body = body;
        this.reactions = reactions;
        this.timeline_url = timeline_url;
        this.performedViaGithubApp = performedViaGithubApp;
        this.state_reason = state_reason;
    }

    public String getUrl() {
        return url;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
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

    public List<String> getLabels() {
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

    public List<String> getAssignees() {
        return assignees;
    }

    public String getMilestone() {
        return milestone;
    }

    public int getComments() {
        return comments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public String getAuthorAssociation() {
        return authorAssociation;
    }

    public String getActiveLockReason() {
        return activeLockReason;
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

    public Object getPerformedViaGithubApp() {
        return performedViaGithubApp;
    }

    public String getState_reason() {
        return state_reason;
    }
}