import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class Start {


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student(1,7,77);
        Student student2 = new Student(1,8,88);
        Student student3 = new Student(1,9,99);
        list.add(student1);
        list.add(student2);
        list.add(student3);


    }
}
@Data
class Student{

    int id;
    int min;
    int avg;

    public Student(int id, int min, int avg) {
        this.id = id;
        this.min = min;
        this.avg = avg;
    }
}
