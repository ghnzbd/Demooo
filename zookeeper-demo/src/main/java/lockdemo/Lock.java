package lockdemo;

import lombok.Data;

/**
 * @author CBeann
 * @create 2020-03-13 11:15
 */
@Data
public class Lock {
    private String lockId;//888
    private String path;//888.R00001
    private boolean active;//激活

    public Lock(String lockId,String path){
        this.lockId = lockId;
        this.path = path;
    }
}
