package com.mulesoft.connector.github.internal.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class IssueResponse {

    private String title;

    private String description;

    private String type;

    public static class ActiveLockReason{
        private ArrayList<String> type;
    }

    public static class AdditionalProperties{
        private String type;
    }

    public static class Admin{
        private String type;
    }

    public static class AllowAutoMerge{
        private String type;
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private ArrayList<Boolean> examples;
    }

    public static class AllowForking{
        private String description;
        private String type;
    }

    public static class AllowMergeCommit{
        private String type;
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private ArrayList<Boolean> examples;
    }

    public static class  AllowRebaseMerge{
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private String type;
        private ArrayList<Boolean> examples;
    }

    public static class  AllowSquashMerge{
        private String type;
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private ArrayList<Boolean> examples;
    }

    public static class  AllowUpdateBranch{
        private String type;
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private ArrayList<Boolean> examples;
    }

    public static class AnonymousAccessEnabled{
        private String type;
        private String description;
    }

    public static class  AnyOf{
        private String type;
        private String title;
        private String description;
        private Properties properties;
        private ArrayList<String> required;
    }

    public static class  Archived{
        private String description;
        @JsonProperty("default")
        private boolean mydefault;
        private String type;
    }

    public static class  ArchiveUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  Assignee{
        private ArrayList<AnyOf> anyOf;
    }

    public static class  Assignees{
        private ArrayList<String> type;
        private Items items;
    }

    public static class  AssigneesUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  AuthorAssociation{
        private String title;
        private String type;
        private String description;
        @JsonProperty("enum")
        private ArrayList<String> myenum;
        private ArrayList<String> examples;
    }

    public static class  AvatarUrl{
        private String type;
        private String format;
        private ArrayList<String> examples;
    }

    public static class  BlobsUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  Body{
        private String description;
        private ArrayList<String> type;
        private ArrayList<String> examples;
    }

    public static class  BodyHtml{
        private String type;
    }

    public static class  BodyText{
        private String type;
    }

    public static class  BranchesUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  Checks{
        private String type;
    }

    public static class  ClientId{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  ClientSecret{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  CloneUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  ClosedAt{
        private ArrayList<String> type;
        private String format;
        private ArrayList<Date> examples;
    }

    public static class  ClosedBy{
        private ArrayList<AnyOf> anyOf;
    }

    public static class  ClosedIssues{
        private String type;
        private ArrayList<Integer> examples;
    }

    public static class  CollaboratorsUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  Color{
        private ArrayList<String> type;
    }

    public static class  Comments{
        private String type;
    }

    public static class  CommentsUrl{
        private String type;
        private String format;
        private ArrayList<String> examples;
    }

    public static class  CommitsUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  CompareUrl{
        private String type;
        private ArrayList<String> examples;
    }

    public static class  Confused{
        public String type;
    }

    public static class  Contents{
        public String type;
    }

    public static class  ContentsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  ContributorsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  CreatedAt{
        public String type;
        public String format;
        public ArrayList<Date> examples;
    }

    public static class  Creator{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  Default{
        public String type;
    }

    public static class  DefaultBranch{
        public String description;
        public String type;
        public ArrayList<String> examples;
    }

    public static class  DeleteBranchOnMerge{
        public String type;
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public ArrayList<Boolean> examples;
    }

    public static class  Deployments{
        public String type;
    }

    public static class  DeploymentsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Description{
        public ArrayList<String> type;
        public ArrayList<String> examples;
    }

    public static class  DiffUrl{
        public ArrayList<String> type;
        public String format;
    }

    public static class  Disabled{
        public String type;
        public String description;
    }

    public static class  DownloadsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Draft{
        public String type;
    }

    public static class  DueOn{
        public ArrayList<String> type;
        public String format;
        public ArrayList<Date> examples;
    }

    public static class  Email{
        public ArrayList<String> type;
    }

    public static class  Events{
        public String description;
        public String type;
        public Items items;
        public ArrayList<String> examples;
    }

    public static class  EventsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Example{
        public String issues;
        public String deployments;
    }

    public static class  ExternalUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Eyes{
        public String type;
    }

    public static class  FollowersUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class FollowingUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class Fork{
        public String type;
    }

    public static class Forks{
        public String type;
    }

    public static class ForksCount{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class ForksUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class FullName{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GistsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GitCommitsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GitRefsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GitTagsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GitUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  GravatarId{
        public ArrayList<String> type;
        public ArrayList<String> examples;
    }

    public static class  HasDownloads{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
        public ArrayList<Boolean> examples;
    }

    public static class  HasIssues{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
        public ArrayList<Boolean> examples;
    }

    public static class  HasPages{
        public String type;
    }

    public static class  HasProjects{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
        public ArrayList<Boolean> examples;
    }

    public static class  HasWiki{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
        public ArrayList<Boolean> examples;
    }

    public static class  Heart{
        public String type;
    }

    public static class  Homepage{
        public ArrayList<String> type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  HooksUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Hooray{
        public String type;
    }

    public static class  HtmlUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Id{
        public String type;
        public ArrayList<Integer> examples;
        public String description;
        public String format;
    }

    public static class  InstallationsCount{
        public String description;
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  IssueCommentUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  IssueEventsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Issues{
        public String type;
    }

    public static class  IssuesUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  IsTemplate{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
        public ArrayList<Boolean> examples;
    }

    public static class  Items{
        public ArrayList<OneOf> oneOf;
        public String title;
        public String description;
        public String type;
        public Properties properties;
        public ArrayList<String> required;
    }

    public static class  Key{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  KeysUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Labels{
        public String description;
        public String type;
        public Items items;
        public ArrayList<String> examples;
    }

    public static class  LabelsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Language{
        public ArrayList<String> type;
    }

    public static class  LanguagesUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Laugh{
        public String type;
    }

    public static class  License{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  Locked{
        public String type;
    }

    public static class  Login{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Maintain{
        public String type;
    }

    public static class  MasterBranch{
        public String type;
    }

    public static class  MergeCommitMessage{
        public String type;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        public String description;
    }

    public static class  MergeCommitTitle{
        public String type;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        public String description;
    }

    public static class  MergedAt{
        public ArrayList<String> type;
        public String format;
    }

    public static class  MergesUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Metadata{
        public String type;
    }

    public static class  Milestone{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  MilestonesUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  MirrorUrl{
        public ArrayList<String> type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Name{
        public ArrayList<String> type;
        public String description;
        public ArrayList<String> examples;
    }

    public static class  NetworkCount{
        public String type;
    }

    public static class  NodeId{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  NotificationsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Number{
        public String description;
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  OneOf{
        public String type;
        public Properties properties;
    }

    public static class  OpenIssues{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  OpenIssuesCount{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  Organization{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  OrganizationsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Owner{
        public String title;
        public String description;
        public String type;
        public Properties properties;
        public ArrayList<String> required;
        public ArrayList<AnyOf> anyOf;
    }

    public static class  PatchUrl{
        public ArrayList<String> type;
        public String format;
    }

    public static class  Pem{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  PerformedViaGithubApp{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  Permissions{
        public String type;
        public Properties properties;
        public ArrayList<String> required;
        public String description;
        public AdditionalProperties additionalProperties;
        public Example example;
    }

    public static class  Private{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
    }

    public static class  Properties{
        public Id id;
        public NodeId node_id;
        public Url url;
        public RepositoryUrl repository_url;
        public LabelsUrl labels_url;
        public CommentsUrl comments_url;
        public EventsUrl events_url;
        public HtmlUrl html_url;
        public Number number;
        public State state;
        public StateReason state_reason;
        public Title title;
        public Body body;
        public User user;
        public Labels labels;
        public Assignee assignee;
        public Assignees assignees;
        public Milestone milestone;
        public Locked locked;
        public ActiveLockReason active_lock_reason;
        public Comments comments;
        public PullRequest pull_request;
        public ClosedAt closed_at;
        public CreatedAt created_at;
        public UpdatedAt updated_at;
        public Draft draft;
        public ClosedBy closed_by;
        public BodyHtml body_html;
        public BodyText body_text;
        public TimelineUrl timeline_url;
        public Repository repository;
        public PerformedViaGithubApp performed_via_github_app;
        public AuthorAssociation author_association;
        public Reactions reactions;
        public Name name;
        public FullName full_name;
        public License license;
        public Organization organization;
        public Forks forks;
        public Permissions permissions;
        public Owner owner;
        @JsonProperty("private")
        public Private myprivate;
        public Description description;
        public Fork fork;
        public ArchiveUrl archive_url;
        public AssigneesUrl assignees_url;
        public BlobsUrl blobs_url;
        public BranchesUrl branches_url;
        public CollaboratorsUrl collaborators_url;
        public CommitsUrl commits_url;
        public CompareUrl compare_url;
        public ContentsUrl contents_url;
        public ContributorsUrl contributors_url;
        public DeploymentsUrl deployments_url;
        public DownloadsUrl downloads_url;
        public ForksUrl forks_url;
        public GitCommitsUrl git_commits_url;
        public GitRefsUrl git_refs_url;
        public GitTagsUrl git_tags_url;
        public GitUrl git_url;
        public IssueCommentUrl issue_comment_url;
        public IssueEventsUrl issue_events_url;
        public IssuesUrl issues_url;
        public KeysUrl keys_url;
        public LanguagesUrl languages_url;
        public MergesUrl merges_url;
        public MilestonesUrl milestones_url;
        public NotificationsUrl notifications_url;
        public PullsUrl pulls_url;
        public ReleasesUrl releases_url;
        public SshUrl ssh_url;
        public StargazersUrl stargazers_url;
        public StatusesUrl statuses_url;
        public SubscribersUrl subscribers_url;
        public SubscriptionUrl subscription_url;
        public TagsUrl tags_url;
        public TeamsUrl teams_url;
        public TreesUrl trees_url;
        public CloneUrl clone_url;
        public MirrorUrl mirror_url;
        public HooksUrl hooks_url;
        public SvnUrl svn_url;
        public Homepage homepage;
        public Language language;
        public ForksCount forks_count;
        public StargazersCount stargazers_count;
        public WatchersCount watchers_count;
        public Size size;
        public DefaultBranch default_branch;
        public OpenIssuesCount open_issues_count;
        public IsTemplate is_template;
        public Topics topics;
        public HasIssues has_issues;
        public HasProjects has_projects;
        public HasWiki has_wiki;
        public HasPages has_pages;
        public HasDownloads has_downloads;
        public Archived archived;
        public Disabled disabled;
        public Visibility visibility;
        public PushedAt pushed_at;
        public AllowRebaseMerge allow_rebase_merge;
        public TemplateRepository template_repository;
        public TempCloneToken temp_clone_token;
        public AllowSquashMerge allow_squash_merge;
        public AllowAutoMerge allow_auto_merge;
        public DeleteBranchOnMerge delete_branch_on_merge;
        public AllowUpdateBranch allow_update_branch;
        public UseSquashPrTitleAsDefault use_squash_pr_title_as_default;
        public SquashMergeCommitTitle squash_merge_commit_title;
        public SquashMergeCommitMessage squash_merge_commit_message;
        public MergeCommitTitle merge_commit_title;
        public MergeCommitMessage merge_commit_message;
        public AllowMergeCommit allow_merge_commit;
        public AllowForking allow_forking;
        public WebCommitSignoffRequired web_commit_signoff_required;
        public SubscribersCount subscribers_count;
        public NetworkCount network_count;
        public OpenIssues open_issues;
        public Watchers watchers;
        public MasterBranch master_branch;
        public StarredAt starred_at;
        public AnonymousAccessEnabled anonymous_access_enabled;
        public Key key;
        public SpdxId spdx_id;
        public Email email;
        public Login login;
        public AvatarUrl avatar_url;
        public GravatarId gravatar_id;
        public FollowersUrl followers_url;
        public FollowingUrl following_url;
        public GistsUrl gists_url;
        public StarredUrl starred_url;
        public SubscriptionsUrl subscriptions_url;
        public OrganizationsUrl organizations_url;
        public ReposUrl repos_url;
        public ReceivedEventsUrl received_events_url;
        public Type type;
        public SiteAdmin site_admin;
        public Admin admin;
        public Pull pull;
        public Triage triage;
        public Push push;
        public Maintain maintain;
        public Slug slug;
        public ExternalUrl external_url;
        public Events events;
        public InstallationsCount installations_count;
        public ClientId client_id;
        public ClientSecret client_secret;
        public WebhookSecret webhook_secret;
        public Pem pem;
        public Issues issues;
        public Checks checks;
        public Metadata metadata;
        public Contents contents;
        public Deployments deployments;
        public TotalCount total_count;
        @JsonProperty("-1")
        private int plusOne;
        @JsonProperty("-1")
        private int minusOne;
        public Laugh laugh;
        public Confused confused;
        public Heart heart;
        public Hooray hooray;
        public Eyes eyes;
        public Rocket rocket;
        public Color color;
        @JsonProperty("default")
        public Default mydefault;
        public Creator creator;
        public ClosedIssues closed_issues;
        public DueOn due_on;
        public MergedAt merged_at;
        public DiffUrl diff_url;
        public PatchUrl patch_url;
    }

    public static class  Pull{
        public String type;
    }

    public static class  PullRequest{
        public String type;
        public Properties properties;
        public ArrayList<String> required;
    }

    public static class  PullsUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Push{
        public String type;
    }

    public static class  PushedAt{
        public ArrayList<String> type;
        public String format;
        public ArrayList<Date> examples;
    }

    public static class  Reactions{
        public String title;
        public String type;
        public Properties properties;
        public ArrayList<String> required;
    }

    public static class  ReceivedEventsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  ReleasesUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Repository{
        public String title;
        public String description;
        public String type;
        public Properties properties;
        public ArrayList<String> required;
    }

    public static class  RepositoryUrl{
        public String type;
        public String format;
    }

    public static class  ReposUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  Rocket{
        public String type;
    }

    public static class  Root{
        public String title;
        public String description;
        public String type;
        public Properties properties;
        public ArrayList<String> required;
    }

    public static class  SiteAdmin{
        public String type;
    }

    public static class  Size{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  Slug{
        public String description;
        public String type;
        public ArrayList<String> examples;
    }

    public static class  SpdxId{
        public ArrayList<String> type;
        public ArrayList<String> examples;
    }

    public static class  SquashMergeCommitMessage{
        public String type;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        public String description;
    }

    public static class  SquashMergeCommitTitle{
        public String type;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        public String description;
    }

    public static class  SshUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  StargazersCount{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  StargazersUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  StarredAt{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  StarredUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  State{
        public String description;
        public String type;
        public ArrayList<String> examples;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        @JsonProperty("default")
        public String mydefault;
    }

    public static class  StateReason{
        public String description;
        public ArrayList<String> type;
        @JsonProperty("enum")
        public ArrayList<String> myenum;
        public ArrayList<String> examples;
    }

    public static class  StatusesUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  SubscribersCount{
        public String type;
    }

    public static class  SubscribersUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  SubscriptionsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  SubscriptionUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  SvnUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  TagsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  TeamsUrl{
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  TempCloneToken{
        public String type;
    }

    public static class  TemplateRepository{
        public ArrayList<String> type;
        public Properties properties;
    }

    public static class  TimelineUrl{
        public String type;
        public String format;
    }

    public static class  Title{
        public String description;
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Topics{
        public String type;
        public Items items;
    }

    public static class  TotalCount{
        public String type;
    }

    public static class  TreesUrl{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  Triage{
        public String type;
    }

    public static class  Type{
        public String type;
        public ArrayList<String> examples;
    }

    public static class  UpdatedAt{
        public String type;
        public String format;
        public ArrayList<Date> examples;
    }

    public static class  Url{
        public String description;
        public String type;
        public String format;
        public ArrayList<String> examples;
    }

    public static class  User{
        public ArrayList<AnyOf> anyOf;
    }

    public static class  UseSquashPrTitleAsDefault{
        public String type;
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public boolean deprecated;
    }

    public static class  Visibility{
        public String description;
        @JsonProperty("default")
        public String mydefault;
        public String type;
    }

    public static class  Watchers{
        public String type;
    }

    public static class  WatchersCount{
        public String type;
        public ArrayList<Integer> examples;
    }

    public static class  WebCommitSignoffRequired{
        public String description;
        @JsonProperty("default")
        public boolean mydefault;
        public String type;
    }

    public static class  WebhookSecret{
        public ArrayList<String> type;
        public ArrayList<String> examples;
    }

}
