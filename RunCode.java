import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class RunCode     {
    public static int indexCheck = 0;
    public static int index = 0;
    public static int countCourse = 0;

    public static Student student = new Student();
    public static Subject subject = new Subject();

    public static Course course = new Course();





    public static void main(String[] args) {
        var input = new Scanner(System.in);
//        danh sách thông tin sinh viên;
        ArrayList<Student> students = new ArrayList<>();

//        danh sách môn học;
        ArrayList<Subject> subjects = new ArrayList<>();

        ArrayList<Course> courses = new ArrayList<>();

        boolean check = true;
        while(check) {
            showMenu();
            System.out.println("Xin mời lựa chọn: ");
            var choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    subjects.add(subject.addSubject(input));
                    countCourse = 1;
                    break;
                case 2:
                    students.add(student.addStudent(input));
                    break;
                case 3:
                    courses.add(course.addCourse(subjects,input));
                    break;
                case 4:
                case 5:
                    subject.showSubject(subjects);
                    break;
                case 8:
                    boolean check1 = true;
                        System.out.println("a.Sửa thông tin sinh viên.");
                        System.out.println("b.Sửa thông tin môn học.");
                        System.out.println("c.Sửa thông tin lớp học.");
                        System.out.println("Xin mời bạn chọn: ");
                        String k = input.nextLine();
                        switch (k) {
                            case "a": case "A":
                                student.setStudent(input, students);
                                break;
                            case "b": case "B":
                                subject.setSubject(input,subjects);
                                break;
                            case "c": case "C":
                                course.setCourse(input,courses,subject,subjects);
                                break;
                            default:
                                System.out.println("Chức năng không hơp lệ.");
                        }
                    break;
                case 6:
                    student.showStudent(students);
                    break;
                case 7:
                    course.showCourse(courses);
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:

            }

        }

    }
    public static void showMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1.Thêm mới môn học.");
        System.out.println("2.Thêm mới sinh viên.");
        System.out.println("3.Thêm mới khóa học.");
        System.out.println("5.Hiển thị danh sách môn học.");
        System.out.println("6.Hiển thị danh sách sinh viên.");
        System.out.println("7.Hiển thị danh sách lớp học.");
        System.out.println("8.Sửa thông tin sinh viên,môn học,lớp học");
        System.out.println("9.Xóa thông tin sinh viên,môn học,lớp học");
    }
}
