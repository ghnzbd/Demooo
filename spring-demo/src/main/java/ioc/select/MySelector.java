package ioc.select;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author CBeann
 * @create 2020-06-14 20:16
 */
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"ioc.select.Teacher"};
    }
}
