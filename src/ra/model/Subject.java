package ra.model;

import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public void inputData (Scanner scanner){
        System.out.println("Nhập mã môn học");
        this.subjectId = scanner.nextLine();
        System.out.println("Nhập tên môn học");
        this.subjectName = scanner.nextLine();


    }
    public void displayData() {
        System.out.println("______THÔNG TIN Môn HỌC______");
        System.out.println("MÃ MÔN HỌC: " + this.subjectId);
        System.out.println("TÊN MÔN HỌC: " + this.subjectName);
    }
}
