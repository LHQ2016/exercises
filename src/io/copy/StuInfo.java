package io.copy;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class StuInfo {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> treeSet = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();
                int num2 = num == 0 ? s2.getChinese() - s1.getChinese() : num;
                int num3 = num2 == 0 ? s2.getMath() - s1.getMath() : num2;
                int num4 = num3 == 0 ? s2.getEnglish() - s1.getEnglish() : num3;
                int num5 = num4 == 0 ? s1.getName().compareTo(s2.getName()) : num4;
                return num5;
            }
        });
        for (int i = 1 ; i < 6; i++) {
            System.out.println("请输入第"+i+"个学生的成绩：");
            Scanner cin = new Scanner(System.in);
            System.out.println("姓名：");
            String name = cin.next();
            System.out.println("语文成绩：");
            int chinese = cin.nextInt();
            System.out.println("数学成绩：");
            int math = cin.nextInt();
            System.out.println("英语成绩：");
            int english = cin.nextInt();

            Student stu = new Student();
            stu.setName(name);
            stu.setChinese(chinese);
            stu.setMath(math);
            stu.setEnglish(english);
            treeSet.add(stu);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\resource\\txt\\students.txt"));
        bw.write("学生信息如下：");
        bw.newLine();
        bw.flush();
        bw.write("姓名    语文成绩    数学成绩    英语成绩");
        bw.newLine();
        bw.flush();
        for (Student stu :
                treeSet) {
            StringBuffer string = new StringBuffer();
            string.append(stu.getName()).append("   ")
                    .append(stu.getChinese()).append("    ")
                    .append(stu.getMath()).append("   ")
                    .append(stu.getEnglish());
            bw.write(string.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println("Ok");

    }
}

class Student {
    private String name;
    private int chinese;
    private int math;
    private int english;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getSum() {
        return this.chinese + this.math + this.english;
    }
}