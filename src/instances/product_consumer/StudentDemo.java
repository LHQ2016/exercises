package instances.product_consumer;

public class StudentDemo {
    public static void main(String[] args) {
        Student stu = new Student();
        SetStudent setStudent = new SetStudent(stu);
        GetStudent getStudent = new GetStudent(stu);
        new Thread(setStudent).start();
        new Thread(getStudent).start();

    }
}
