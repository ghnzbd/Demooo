package json.app;

import untils.JsonUtils;

/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class AAStart {

    public static void main(String[] args) throws Exception{


        String ss="{\"object_kind\":\"merge_request\",\"user\":{\"name\":\"Rongdian Chai\",\"username\":\"chaird\",\"avatar_url\":\"https://secure.gravatar.com/avatar/6c1d6c909407787c50ee14e4adcc4c2d?s=80\\u0026d=identicon\"},\"project\":{\"id\":8150,\"name\":\"Demooo\",\"description\":\"test\",\"web_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"avatar_url\":null,\"git_ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"git_http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\",\"namespace\":\"chaird\",\"visibility_level\":10,\"path_with_namespace\":\"chaird/Demooo\",\"default_branch\":\"master\",\"ci_config_path\":null,\"homepage\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\"},\"object_attributes\":{\"assignee_id\":null,\"author_id\":1313,\"created_at\":\"2020-06-18 18:06:42 +0800\",\"description\":\"dev1 to master\",\"head_pipeline_id\":null,\"id\":41753,\"iid\":9,\"last_edited_at\":null,\"last_edited_by_id\":null,\"merge_commit_sha\":null,\"merge_error\":null,\"merge_params\":{\"force_remove_source_branch\":\"0\"},\"merge_status\":\"unchecked\",\"merge_user_id\":null,\"merge_when_pipeline_succeeds\":false,\"milestone_id\":null,\"source_branch\":\"dev1\",\"source_project_id\":8150,\"state\":\"opened\",\"target_branch\":\"master\",\"target_project_id\":8150,\"time_estimate\":0,\"title\":\"dev1 to master\",\"updated_at\":\"2020-06-18 18:06:42 +0800\",\"updated_by_id\":null,\"url\":\"https://gitlab.corp.youdao.com/chaird/Demooo/merge_requests/9\",\"source\":{\"id\":8150,\"name\":\"Demooo\",\"description\":\"test\",\"web_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"avatar_url\":null,\"git_ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"git_http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\",\"namespace\":\"chaird\",\"visibility_level\":10,\"path_with_namespace\":\"chaird/Demooo\",\"default_branch\":\"master\",\"ci_config_path\":null,\"homepage\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\"},\"target\":{\"id\":8150,\"name\":\"Demooo\",\"description\":\"test\",\"web_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"avatar_url\":null,\"git_ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"git_http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\",\"namespace\":\"chaird\",\"visibility_level\":10,\"path_with_namespace\":\"chaird/Demooo\",\"default_branch\":\"master\",\"ci_config_path\":null,\"homepage\":\"https://gitlab.corp.youdao.com/chaird/Demooo\",\"url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"ssh_url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"http_url\":\"https://gitlab.corp.youdao.com/chaird/Demooo.git\"},\"last_commit\":{\"id\":\"055a3a5bc1a89332e61486cbfd2af6a9dd57e48f\",\"message\":\"Update hello.txt\",\"timestamp\":\"2020-06-18T18:05:32+08:00\",\"url\":\"https://gitlab.corp.youdao.com/chaird/Demooo/commit/055a3a5bc1a89332e61486cbfd2af6a9dd57e48f\",\"author\":{\"name\":\"Rongdian Chai\",\"email\":\"chaird@rd.netease.com\"}},\"work_in_progress\":false,\"total_time_spent\":0,\"human_total_time_spent\":null,\"human_time_estimate\":null,\"action\":\"open\"},\"labels\":[],\"changes\":{\"total_time_spent\":{\"previous\":null,\"current\":0}},\"repository\":{\"name\":\"Demooo\",\"url\":\"git@gitlab.corp.youdao.com:chaird/Demooo.git\",\"description\":\"test\",\"homepage\":\"https://gitlab.corp.youdao.com/chaird/Demooo\"}}";


        WHRoot myRoot1 = JsonUtils.jsonToPojo(ss, WHRoot.class);
        System.out.println(myRoot1);


    }
}
