import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Subject {
    public static int index = 0;
    public static String idStr = "SUB";
    public static int idNub = 1001;
    private String id;
    private String name;
    private int credit;
    private int lesson;
    private int test;
    public Subject() {
        id = "";
        name = "";
        credit = 0;
        lesson = 0;
        test = 0;
    }

    public Subject(String id, String name, int credit, int lesson, int test) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.lesson = lesson;
        this.test = test;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = idStr + idNub;
        idNub ++;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

//    Them mon hoc vao arraylist
    public Subject addSubject(Scanner input) {
        System.out.println("Mã môn học: ");
        setId();
        String ids = getId();
        System.out.println(ids);
        System.out.println("Tên môn học: ");
        String names = input.nextLine();
        System.out.println("Số tín chỉ: ");
        int cre = input.nextInt();
        System.out.println("Số tiết học: ");
        int les = input.nextInt();
        System.out.println("Số bài kiểm tra: ");
        int tes = input.nextInt();
        input.nextLine();

        return new Subject(id,names,cre,les,tes);

    }


    public void showSubject(ArrayList<Subject> subjects) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n","Mã Môn Học","Tên Môn Học","Số Tín Chỉ","Số Tiết Học","Số Kiểm Tra");
        for (var item:
             subjects) {
            showSubjectList(item);

        }
    }

    private void showSubjectList(Subject item) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n",item.getId(),item.getName(),item.getCredit(),item.getLesson(),item.getTest());
    }




    public void setSubject(Scanner input, ArrayList<Subject> subjects) {
        System.out.println("Nhập mã môn: ");
        String idS = input.nextLine();
        var subject = findSubject(idS,subjects);
        if(subject != null) {
            boolean check = true;
            while(check) {
                showMenu();
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        String name = input.nextLine();
                        subjects.get(index).setName(name);
                        show();
                        break;
                    case 2:
                        int cre = input.nextInt();
                        subjects.get(index).setCredit(cre);
                        show();
                        break;
                    case 3:
                        int les = input.nextInt();
                        subjects.get(index).setLesson(les);
                        show();
                        break;

                    case 4:
                        int te = input.nextInt();
                        subjects.get(index).setTest(te);
                        show();
                        break;
                    default:
                        check = false;
                }
            }
        } else {
            System.out.println("Mã môn học không hợp lệ.");
        }


    }
    private void show() {
        System.out.println("Sửa thành công");
    }

    private void showMenu() {
        System.out.println("1.Sửa tên môn học.");
        System.out.println("2.Sửa số tín chỉ.");
        System.out.println("3.Sửa số tiết học.");
        System.out.println("4.Sửa số kiểm tra.");
    }

    public Subject findSubject(String idS,ArrayList<Subject> subjects) {
        for (int i = 0; i < subjects.size(); i++) {
            if(idS.compareTo(subjects.get(i).getId()) == 0) {
                index = i;
                return subjects.get(i);
            }
        }
        return null;
    }


}
