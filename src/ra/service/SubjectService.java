package ra.service;

import ra.model.Student;
import ra.model.Subject;

import java.util.Scanner;

public class SubjectService {
    public static Scanner scanner = new Scanner(System.in);
    private static Subject[] arrSubject = new Subject[10];
    private static int currentIndexSubject = 0;
    public static void subjectManagerment(){
        int choice;
        do {
            System.out.println(" *********************MARK-MANAGEMENT************************");
            System.out.println("1.Thêm mới môn học");
            System.out.println("2.Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3.Thay đổi thông tin học môn học theo mã id");
            System.out.println("4.Xóa môn học theo mã id ");
            System.out.print("5:Thoát");

            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống
            switch (choice) {
                case 1:
                    System.out.print("Nhập số môn muốn nhập: ");
                    int numSubject = Integer.parseInt(scanner.nextLine());
                    if (numSubject + currentIndexSubject < 10) {
                        for (int i = currentIndexSubject; i < numSubject; i++) {
                            arrSubject[currentIndexSubject] = new Subject();
                            arrSubject[currentIndexSubject].inputData(scanner);
                            currentIndexSubject++;
                        }
                    }
                    break;
                case 2:
                    //Hiển thị thông tin tất cả học sinh
                    for (int i = 0; i < currentIndexSubject; i++) {
                        arrSubject[i].displayData();
                    }
                    break;
                case 3:
                  // Thay đổi thông tin học môn học theo mã id
                    updateSubject();
                    break;

                case 4:
                        // xoá
                    deleteSubject();
                    break;
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);

    }
    // method sửa môn
    public static void updateSubject(){
        System.out.println("Nhập mã môn học");
        String updateId = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < currentIndexSubject; i++) {
            if (arrSubject[i].getSubjectId() == updateId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Mã học sinh cần sửa không tìm thấy");
        } else {

            System.out.println("Đổi tên học viên");
            String newName = scanner.nextLine();
            arrSubject[index].setSubjectName(newName);

            System.out.println(" đổi thành công");
        }
    }

    // method xoá hoc sinh
    public static void deleteSubject(){
        System.out.println("Nhập mã môn cần xoá");
        String deleteId = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < currentIndexSubject; i++) {
            if (arrSubject[i].getSubjectId() == deleteId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Mã môn hoc cần xoá không tìm thấy");
        } else {
            for (int i = 0; i < currentIndexSubject; i++) {
                for (int j = Integer.parseInt(deleteId); j < currentIndexSubject - 1; j++) {
                    arrSubject[j] = arrSubject[j + 1];
                }
            }

        }
    }

}
