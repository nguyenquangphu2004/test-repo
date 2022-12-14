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
//     Ch???c n??ng hi???n th??? danh s??ch sinh vi??n
    public void showStudent(ArrayList<Student> students) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%s%-20s%s%-12s%s%-8s%s%-15s%s%-14s%s%-15s%s%-15s\n", "M?? Sinh Vi??n", "|", "H??? V?? T??n", "|", "Gi???i T??nh", "|", "Tu???i", "|", "T??n L???p", "|", "Chuy??n Ng??nh", "|", "S??? ??i???n Tho???i", "|", "?????a Ch???");
        for (var item : students) {
            showList(item);
        }
    }

    private void showList(Student item) {
        System.out.printf("%-15s%s%-20s%s%-12s%s%-8s%s%-15s%s%-14s%s%-15s%s%-15s\n", item.getId(), "|", item.getFullName(), "|", item.getGender(), "|", item.getAge(), "|", item.getNameClass(), "|", item.getMajor(), "|", item.getPhone(), "|", item.getAddress());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }


    //    Nh???p th??ng tin sinh vi??n
    public Student addStudent(Scanner input) {
        System.out.println("M?? sinh vi??n: ");
        setId();
        String idS = getId();
        System.out.println(id);

        System.out.println("H??? v?? t??n: ");
        String fullNa = input.nextLine();

        System.out.println("Gi???i t??nh");
        String gend = input.nextLine();

        System.out.println("Tu???i: ");
        var ages = input.nextInt();

        input.nextLine();
        System.out.println("T??n l???p: ");
        String nameCl = input.nextLine();

        System.out.println("Chuy??n ng??nh: ");
        String majr = input.nextLine();

        System.out.println("S??? ??i???n tho???i: ");
        String phon = input.nextLine();

        System.out.println("?????a ch???: ");
        String addre = input.nextLine();

        return new Student(idS, fullNa, gend, ages, nameCl, majr, phon, addre);
    }


    //    S???a th??ng tin sinh vi??n.
    public void setStudent(Scanner input, ArrayList<Student> students) {
        System.out.println("Nh???p m?? sinh vi??n c???n s???a: ");
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
                        System.out.println("H??? v?? t??n: ");
                        var check = input.nextLine();
                        students.get(RunCode.indexCheck).setFullName(check);
                        showFinish("S???a th??nh c??ng");
                        break;
                    case 2:
                        System.out.println("Gi???i t??nh: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setGender(check);
                        showFinish("S???a th??nh c??ng");

                        break;
                    case 3:
                        System.out.println("Tu???i: ");
                        int a = input.nextInt();
                        input.nextLine();
                        students.get(RunCode.indexCheck).setAge(a);
                        showFinish("S???a th??nh c??ng");

                        break;
                    case 4:
                        System.out.println("T??n l???p: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setNameClass(check);
                        showFinish("S???a th??nh c??ng");
                        break;

                    case 5:
                        System.out.println("Chuy??n ng??nh: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setMajor(check);
                        showFinish("S???a th??nh c??ng");
                        break;

                    case 6:
                        System.out.println("S??? ??i???n tho???i: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setPhone(check);
                        showFinish("S???a th??nh c??ng");
                        break;

                    case 7:
                        System.out.println("?????a ch???: ");
                        check = input.nextLine();
                        students.get(RunCode.indexCheck).setAddress(check);
                        showFinish("S???a th??nh c??ng");
                        break;

                    default:
                        System.out.println("Sai ch???c n??ng.");
                        count = false;
                }
            }
        } else {
            System.out.println("M?? sinh vi??n kh??ng h???p l???");
        }
    }

    public void showMeunu() {
        System.out.println("1.S???a h??? v?? t??n.");
        System.out.println("2.S???a gi???i t??nh.");
        System.out.println("3.S???a tu???i.");
        System.out.println("4.S???a t??n l???p.");
        System.out.println("5.S???a t??n chuy??n ng??nh.");
        System.out.println("6.S???a s??? ??i???n tho???i.");
        System.out.println("7.S???a ?????a ch???.");
        System.out.println("Xin m???i l???a ch???n.");
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


