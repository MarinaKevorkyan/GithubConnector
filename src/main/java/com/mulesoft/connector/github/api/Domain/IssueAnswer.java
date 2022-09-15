package com.mulesoft.connector.github.api.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class IssueAnswer {

    private int id;
    private String node_id;
    private String url;
    private String repository_url;
    private String labels_url;
    private String comments_url;
    private String events_url;
    private String html_url;
    private int number;
    private String state;
    private String title;
    private String body;
    private User user;
    private ArrayList<Label> labels;
    private Assignee assignee;
    private ArrayList<Assignee> assignees;
    private Milestone milestone;
    private boolean locked;
    private String active_lock_reason;
    private int comments;
    private PullRequest pull_request;
    private Date closed_at;
    private Date created_at;
    private Date updated_at;
    private User closed_by;
    private String author_association;
    private String state_reason;

    private static class Assignee{
        public String login;
        public int id;
        public String node_id;
        public String avatar_url;
        public String gravatar_id;
        public String url;
        public String html_url;
        public String followers_url;
        public String following_url;
        public String gists_url;
        public String starred_url;
        public String subscriptions_url;
        public String organizations_url;
        public String repos_url;
        public String events_url;
        public String received_events_url;
        public String type;
        public boolean site_admin;
    }

    private static class Label{
        public int id;
        public String node_id;
        public String url;
        public String name;
        public String description;
        public String color;
        @JsonProperty("default")
        public boolean mydefault;
    }

    private static class Milestone{
        public String url;
        public String html_url;
        public String labels_url;
        public int id;
        public String node_id;
        public int number;
        public String state;
        public String title;
        public String description;
        public User creator;
        public int open_issues;
        public int closed_issues;
        public Date created_at;
        public Date updated_at;
        public Date closed_at;
        public Date due_on;
    }

    private static class PullRequest{
        public String url;
        public String html_url;
        public String diff_url;
        public String patch_url;
    }
}
