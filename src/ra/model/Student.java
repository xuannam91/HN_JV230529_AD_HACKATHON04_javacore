package ra.model;

import java.util.Scanner;

public class Student {
    public static int nextID = 1;
    private int studentId;
    private String studentName;
    private String birthDay;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
        this.studentId = nextID++;
    }

    public Student(String studentName, String birthDay, String address, boolean gender, String phone) {
        this.studentId = nextID++;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        Student.nextID = nextID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void inputData(Scanner scanner) {
        boolean isExit = true;
//        nhập tên
        System.out.println("Nhập vào tên học sinh");
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length() > 0) {
                break;
            } else {
                System.out.println("Tên không được bỏ trống");
            }
        } while (isExit);

        // Nhập ngày

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        this.birthDay = scanner.nextLine();
        //Địa chỉ
        System.out.println("Nhập địa chỉ");
        do {
            this.address = scanner.nextLine();
            if (this.address.length() > 0) {
                break;
            } else {
                System.out.println("Địa chỉ không được bỏ trống");
            }
        } while (isExit);

        //        Giới tính
        System.out.println("Nhập giới tính");
        this.gender = Boolean.parseBoolean(scanner.nextLine());

        // số điện thoại
        boolean validPhone = false;
        while (!validPhone) {
            System.out.print("Nhập số điện thoại (10 hoặc 11 số, bắt đầu bằng số 0): ");
            this.phone = scanner.nextLine();
            if (isValidPhone(this.phone)) {
                validPhone = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }
    }


    private boolean isValidPhone(String phone) {
        return phone.matches("0[0-9]{9,10}");
    }


    public void displayData() {
        System.out.printf("Mã học sinh: %d - Tên học sinh: %s - Ngày sinh: %s\n", this.studentId, this.studentName, this.birthDay);
        System.out.printf("Địa chỉ: %s - Giới tính: %b - Số ĐT: %s\n", this.address, this.gender, this.phone);
    }
}
