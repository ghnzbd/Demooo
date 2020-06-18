import entity.Student;

/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class Start {

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.setId(1);
        student.setLevel((byte) 1);
        student.setName("123");





        String str="1";

        System.out.println(student);
    }
}
