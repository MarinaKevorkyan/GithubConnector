package com.mulesoft.connector.github.api.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class IssueResponse{

    private int id;
    @JsonProperty("node_id")
    private String nodeId;
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
    private int number;
    private String state;
    private String title;
    private String body;
    private User user;
    private ArrayList<Label> labels;
    private User assignee;
    private ArrayList<User> assignees;
    private Milestone milestone;
    private boolean locked;
    @JsonProperty("active_lock_reason")
    private String activeLockReason;
    private int comments;
    @JsonProperty("pull_request")
    private PullRequest pullRequest;
    @JsonProperty("closed_at")
    private String closedAt;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_by")
    private User closedBy;
    @JsonProperty("author_association")
    private String authorAssociation;
    @JsonProperty("state_reason")
    private String stateReason;

    private static class Label{
        public int id;
        @JsonProperty("node_id")
        public String nodeId;
        public String url;
        public String name;
        public String description;
        public String color;
        @JsonProperty("default")
        public boolean mydefault;
    }

    private static class Milestone{
        public String url;
        @JsonProperty("html_url")
        public String htmlUrl;
        @JsonProperty("labels_url")
        public String labelsUrl;
        public int id;
        @JsonProperty("node_id")
        public String nodeId;
        public int number;
        public String state;
        public String title;
        public String description;
        public User creator;
        @JsonProperty("open_issues")
        public int openIssues;
        @JsonProperty("closed_issues")
        public int closedIssues;
        @JsonProperty("created_at")
        public String createdAt;
        @JsonProperty("updated_at")
        public String updatedAt;
        @JsonProperty("closed_at")
        public String closedAt;
        @JsonProperty("due_on")
        public String dueOn;
    }

    private static class PullRequest{
        public String url;
        @JsonProperty("html_url")
        public String htmlUrl;
        @JsonProperty("diff_url")
        public String diffUrl;
        @JsonProperty("patch_url")
        public String patchUrl;
    }

    public IssueResponse(){}

    public IssueResponse(int id, String node_id, String url, String repositoryUrl, String labelsUrl, String commentsUrl, String eventsUrl, String htmlUrl, int number, String state, String title, String body, User user, ArrayList<Label> labels, User assignee, ArrayList<User> assignees, Milestone milestone, boolean locked, String activeLockReason, int comments, PullRequest pullRequest, String closedAt, String createdAt, String updatedAt, User closedBy, String authorAssociation, String stateReason) {
        this.id = id;
        this.nodeId = node_id;
        this.url = url;
        this.repositoryUrl = repositoryUrl;
        this.labelsUrl = labelsUrl;
        this.commentsUrl = commentsUrl;
        this.eventsUrl = eventsUrl;
        this.htmlUrl = htmlUrl;
        this.number = number;
        this.state = state;
        this.title = title;
        this.body = body;
        this.user = user;
        this.labels = labels;
        this.assignee = assignee;
        this.assignees = assignees;
        this.milestone = milestone;
        this.locked = locked;
        this.activeLockReason = activeLockReason;
        this.comments = comments;
        this.pullRequest = pullRequest;
        this.closedAt = closedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedBy = closedBy;
        this.authorAssociation = authorAssociation;
        this.stateReason = stateReason;
    }

    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
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

    public int getNumber() {
        return number;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public User getAssignee() {
        return assignee;
    }

    public ArrayList<User> getAssignees() {
        return assignees;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getActiveLockReason() {
        return activeLockReason;
    }

    public int getComments() {
        return comments;
    }

    public PullRequest getPullRequest() {
        return pullRequest;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public User getClosedBy() {
        return closedBy;
    }

    public String getAuthorAssociation() {
        return authorAssociation;
    }

    public String getStateReason() {
        return stateReason;
    }
}
