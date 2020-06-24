/**
  * Copyright 2020 bejson.com 
  */
package json.autocode;
import java.util.List;

/**
 * Auto-generated: 2020-06-18 18:45:35
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GitlabWebhookReq {

    @Override
    public String toString() {
        return "GitlabWebhookReq{" +
                "object_kind='" + object_kind + '\'' +
                ", user=" + user +
                ", project=" + project +
                ", object_attributes=" + object_attributes +
                ", labels=" + labels +
                ", changes=" + changes +
                ", repository=" + repository +
                '}';
    }

    private String object_kind;
    private User user;
    private Project project;
    private Object_attributes object_attributes;
    private List<String> labels;
    private Changes changes;
    private Repository repository;
    public void setObject_kind(String object_kind) {
         this.object_kind = object_kind;
     }
     public String getObject_kind() {
         return object_kind;
     }

    public void setUser(User user) {
         this.user = user;
     }
     public User getUser() {
         return user;
     }

    public void setProject(Project project) {
         this.project = project;
     }
     public Project getProject() {
         return project;
     }

    public void setObject_attributes(Object_attributes object_attributes) {
         this.object_attributes = object_attributes;
     }
     public Object_attributes getObject_attributes() {
         return object_attributes;
     }

    public void setLabels(List<String> labels) {
         this.labels = labels;
     }
     public List<String> getLabels() {
         return labels;
     }

    public void setChanges(Changes changes) {
         this.changes = changes;
     }
     public Changes getChanges() {
         return changes;
     }

    public void setRepository(Repository repository) {
         this.repository = repository;
     }
     public Repository getRepository() {
         return repository;
     }

}