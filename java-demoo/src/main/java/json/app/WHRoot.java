package json.app;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CBeann
 * @create 2020-06-18 19:01
 */
@Data
public class WHRoot {

    private String object_kind;

    private User user;

    private Project project;

    private Object_attributes object_attributes;


    List<String> labels=new ArrayList<>();

    private Changes changes;

    private Repository repository;


}
