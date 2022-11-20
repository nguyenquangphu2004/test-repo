import java.util.ArrayList;
import java.util.Scanner;
public class Student {
    private static String indexStr = "STU";
    private static int indexNubr = 100001;
    private String id;
    private FullName fullName;
    private String address;
    private String gender;
    private int age;
    private String phone;
    private String nameClass;
    private String major;

    public Student() {
        id = "";
        fullName = new FullName();
        address = "";
        gender = "";
        phone = "";
        nameClass = "";
        major = "";
    }

    public Student(String id, String fullName, String gender
            , int age, String nameClass, String major, String phone, String address) {
        this.id = id;
        this.fullName = new FullName();
        setFullName(fullName);
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.nameClass = nameClass;
        this.major = major;
        this.age = age;


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = indexStr + indexNubr;
        indexNubr++;
    }

    public String getFullName() {
        return fullName.last + " " + fullName.mid + fullName.first;
    }

    public void setFullName(String fullName) {

        var words = fullName.split(" ");
        this.fullName.first = words[words.length - 1];
        this.fullName.last = words[0];
        this.fullName.mid = "";
        for (int i = 1; i < words.length - 1; i++) {
            this.fullName.mid += words[i] + " ";
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    //
//
//
//
//
//
//     Chức năng hiển thị danh sách sinh viên
    public void showStudent(ArrayList<Student> students) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%s%-20s%s%-12s%s%-8s%s%-15s%s%-14s%s%-15s%s%-15s\n", "Mã Sinh Viên", "|", "Họ Và Tên", "|", "Giới Tính", "|", "Tuổi", "|", "Tên Lớp", "|", "Chuyên Ngành", "|", "Số Điện Thoại", "|", "Địa Chỉ");
        for (var item : students) {
            showList(item);
        }
    }

    private void showList(Student item) {
        System.out.printf("%-15s%s%-20s%s%-12s%s%-8s%s%-15s%s%-14s%s%-15s%s%-15s\n", item.getId(), "|", item.getFullName(), "|", item.getGender(), "|", item.getAge(), "|", item.getNameClass(), "|", item.getMajor(), "|", item.getPhone(), "|", item.getAddress());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }


    //    Nhập thông tin sinh viên
    public Student addStudent(Scanner input) {
        System.out.println("Mã sinh viên: ");
        setId();
        String idS = getId();
        System.out.println(id);

        System.out.println("Họ và tên: ");
        String fullNa = input.nextLine();

        System.out.println("Giới tính");
        String gend = input.nextLine();

        System.out.println("Tuổi: ");
        var ages = input.nextInt();

        input.nextLine();
        System.out.println("Tên lớp: ");
        String nameCl = input.nextLine();

        System.out.println("Chuyên ngành: ");
        String majr = input.nextLine();

        System.out.println("Số điện thoại: ");
        String phon = input.nextLine();

        System.out.println("Địa chỉ: ");
        String addre = input.nextLine();

        return new Student(idS, fullNa, gend, ages, nameCl, majr, phon, addre);
    }


    //    Sửa thông tin sinh viên.
    public void setStudent(Scanner input, ArrayList<Student> students) {
        System.out.println("Nhập mã sinh viên cần sửa: ");
        String ids = input.nextLine();

        var student = findStudent(ids, students);
        if (student != null) {
            boolean count = true;
            while (count) {
                showMeunu();
                var choice = input.nextInt();
                input.nextLine();
                Student s = new Student();
                switch (choice) {
                    case 1:
                        System.out.println("Họ và tên: ");
                        var check = input.nextLine();
                        students.get(RunCode.indexCheck).setFullName(check);
                        showFinish("Sửa thành công");
                        break;
                    case 2:
                        System.out.println("Giới tính: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setGender(check);
                        showFinish("Sửa thành công");

                        break;
                    case 3:
                        System.out.println("Tuổi: ");
                        int a = input.nextInt();
                        input.nextLine();
                        students.get(RunCode.indexCheck).setAge(a);
                        showFinish("Sửa thành công");

                        break;
                    case 4:
                        System.out.println("Tên lớp: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setNameClass(check);
                        showFinish("Sửa thành công");
                        break;

                    case 5:
                        System.out.println("Chuyên ngành: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setMajor(check);
                        showFinish("Sửa thành công");
                        break;

                    case 6:
                        System.out.println("Số điện thoại: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setPhone(check);
                        showFinish("Sửa thành công");
                        break;

                    case 7:
                        System.out.println("Địa chỉ: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setAddress(check);
                        showFinish("Sửa thành công");
                        break;

                    default:
                        System.out.println("Sai chức năng.");
                        count = false;
                }
            }
        } else {
            System.out.println("Mã sinh viên không hợp lệ");
        }
    }

    public void showMeunu() {
        System.out.println("1.Sửa họ và tên.");
        System.out.println("2.Sửa giới tính.");
        System.out.println("3.Sửa tuổi.");
        System.out.println("4.Sửa tên lớp.");
        System.out.println("5.Sửa tên chuyên ngành.");
        System.out.println("6.Sửa số điện thoại.");
        System.out.println("7.Sửa địa chỉ.");
        System.out.println("Xin mời lựa chọn.");
    }

    public Student findStudent(String ids, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (ids.compareTo(students.get(i).getId()) == 0) {
                RunCode.indexCheck = i;
                return students.get(i);
            }
        }

        return null;
    }

    public void showFinish(String msg) {
        System.out.println(msg);
    }


    public class FullName {
        private String first;
        private String mid;
        private String last;
    }
}


