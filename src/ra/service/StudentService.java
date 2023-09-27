package ra.service;

import ra.model.Student;

import java.util.Date;
import java.util.Scanner;

public class StudentService {
    public static Scanner scanner = new Scanner(System.in);
    private static Student[] arrStudent = new Student[100];
    private static int currentIndexStudent = 0;

    public static void studentManagerment() {

        int choice;
        do {
            System.out.println(" *********************MARK-MANAGEMENT************************");
            System.out.println("1.Thêm mới học sinh");
            System.out.println("2.Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học sinh theo mã id");
            System.out.println("4.Xóa học sinh theo mã id ");
            System.out.print("5:Thoát");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng học sinh: ");
                    int numStudent = Integer.parseInt(scanner.nextLine());
                    if (numStudent + currentIndexStudent < 100) {
                        for (int i = currentIndexStudent; i < numStudent; i++) {
                            arrStudent[currentIndexStudent] = new Student();
                            arrStudent[currentIndexStudent].inputData(scanner);
                            currentIndexStudent++;
                        }
                    }
                    break;
                case 2:
                    //Hiển thị thông tin tất cả học sinh
                    for (int i = 0; i < currentIndexStudent; i++) {
                        arrStudent[i].displayData();
                    }
                    break;
                case 3:
                    //Thay đổi thông tin học sinh theo mã id
                    updateStudent();
                    break;
                case 4:
                        // Xoá
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);

    }


    // Method Thay đổi thông tin học sinh theo mã id
    public static void updateStudent() {
        System.out.println("Nhập mã học sinh");
        int updateId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentIndexStudent; i++) {
            if (arrStudent[i].getStudentId() == updateId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Mã học sinh cần sửa không tìm thấy");
        } else {

            System.out.println("Đổi tên học viên");
            String newName = scanner.nextLine();
            arrStudent[index].setStudentName(newName);

            System.out.println("Đổi ngày sinh");
            String newbirthDay = scanner.nextLine();
            arrStudent[index].setBirthDay(newbirthDay);

            System.out.println("Đổi địa chỉ");
            String newAddress = scanner.nextLine();
            arrStudent[index].setAddress(newAddress);

            System.out.println("Đổi lại giới tính");
            boolean newGender = Boolean.parseBoolean(scanner.nextLine());
            arrStudent[index].setGender(newGender);

            System.out.println("Đổi lại sdt");
            String newPhone = scanner.nextLine();
            arrStudent[index].setPhone(newPhone);

            System.out.println(" đổi thành công");
        }
    }

    // method xoá hoc sinh
    public static void deleteStudent() {
        System.out.println("Nhập mã học sinh cần xoá");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentIndexStudent; i++) {
            if (arrStudent[i].getStudentId() == deleteId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Mã học sinh cần xoá không tìm thấy");
        } else {
            for (int i = 0; i < currentIndexStudent; i++) {
                for (int j = deleteId; j < currentIndexStudent - 1; j++) {
                    arrStudent[j] = arrStudent[j + 1];
                }
            }

        }
    }

}
