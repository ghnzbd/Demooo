package json.app;

import lombok.Data;

/**
 * @author CBeann
 * @create 2020-06-18 20:03
 */
@Data
public class Last_commit {

    private String id;
    private String message;
    private String timestamp;
    private String url;
    private Author author;
}
