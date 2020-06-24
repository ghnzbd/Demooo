package com.example.springbootdemoemail;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CBeann-----------------------
 * @create 2020-06-18 20:08
 */
@Data
public class WHRoot {
    private String object_kind;
    private User user;
    private Project project;
    private Object_attributes object_attributes;
    List<String> labels = new ArrayList<>();
    private Changes changes;
    private Repository repository;
}

@Data
class State {

    private String previous;
    private String current;
}


@Data
class Author {

    private String name;
    private String email;


}

@Data
class Changes {

    private State state;

    private Updated_at updated_at;

    private Total_time_spent total_time_spent;


}

@Data
class Last_commit {

    private String id;
    private String message;
    private String timestamp;
    private String url;
    private Author author;
}


@Data
class Merge_params {

    private String force_remove_source_branch;


}

@Data
class Object_attributes {

    private String assignee_id;
    private int author_id;
    private String created_at;
    private String description;
    private String head_pipeline_id;
    private int id;
    private int iid;
    private String last_edited_at;
    private String last_edited_by_id;
    private String merge_commit_sha;
    private String merge_error;
    private Merge_params merge_params;
    private String merge_status;
    private String merge_user_id;
    private boolean merge_when_pipeline_succeeds;
    private String milestone_id;
    private String source_branch;
    private Integer source_project_id;
    private String state;
    private String target_branch;
    private Integer target_project_id;
    private Integer time_estimate;
    private String title;
    private String updated_at;
    private String updated_by_id;
    private String url;
    private Source source;
    private Target target;
    private Last_commit last_commit;
    private boolean work_in_progress;
    private Integer total_time_spent;
    private String human_total_time_spent;
    private String human_time_estimate;
    private String action;
}


@Data
class Project {


    private int id;
    private String name;
    private String description;
    private String web_url;
    private String avatar_url;
    private String git_ssh_url;
    private String git_http_url;
    private String namespace;
    private int visibility_level;
    private String path_with_namespace;
    private String default_branch;
    private String ci_config_path;
    private String homepage;
    private String url;
    private String ssh_url;
    private String http_url;
}

@Data
class Repository {

    private String name;
    private String url;
    private String description;
    private String homepage;


}

@Data
class Source {

    private int id;
    private String name;
    private String description;
    private String web_url;
    private String avatar_url;
    private String git_ssh_url;
    private String git_http_url;
    private String namespace;
    private Integer visibility_level;
    private String path_with_namespace;
    private String default_branch;
    private String ci_config_path;
    private String homepage;
    private String url;
    private String ssh_url;
    private String http_url;

}


@Data
class Target {

    private int id;
    private String name;
    private String description;
    private String web_url;
    private String avatar_url;
    private String git_ssh_url;
    private String git_http_url;
    private String namespace;
    private int visibility_level;
    private String path_with_namespace;
    private String default_branch;
    private String ci_config_path;
    private String homepage;
    private String url;
    private String ssh_url;
    private String http_url;
}

@Data
class Total_time_spent {

    private String previous;
    private Integer current;


}


@Data
class Updated_at {
    private String previous;
    private String current;


}

@Data
class User {
    private String name;
    private String username;
    private String avatar_url;
}

