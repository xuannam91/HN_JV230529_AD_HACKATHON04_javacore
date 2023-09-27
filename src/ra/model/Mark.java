package ra.model;

import java.util.Scanner;

public class Mark {
    public static int nextMarkId = 1;
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
        this.markId = nextMarkId++;
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = nextMarkId++;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public void inputData (Scanner scanner){
        System.out.println("Nhập vào ten sinh viên");
//        this.student.getStudentId() = scanner.nextLine();
        System.out.println("Nhập vào Môn học");
//        this.subject.getSubjectId() = scanner.nextLine();
        System.out.println("Nhập vào điểm ");
        this.point = Double.parseDouble(scanner.nextLine());


    }
    public void displayData (){
        System.out.println("______THÔNG TIN STUDENT______");
        System.out.println("MÃ ĐIẺM: "+ this.markId);
        System.out.println("TÊN STUDENT: "+this.student);
        System.out.println("MÔN HỌC: "+this.subject);
        System.out.println("ĐIỂM : "+this.point);

    }

}
