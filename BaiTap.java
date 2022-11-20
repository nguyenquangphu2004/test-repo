import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BaiTap {
    public static int index = 0;
    public static void main(String[] args) throws IOException {
        var input = new Scanner(System.in);
        ArrayList<Students> students = new ArrayList<>();
        File file = new File("phu.txt");
        var readFile = new Scanner(file);
//        System.out.printf("%-18s%-18s%-10s\n","Ma sinh vien","Ho va ten","Diem");
        while (readFile.hasNextLine()) {
            var words = readFile.nextLine();
            var stud = words.split(";");
            String id = stud[0];
            String name = stud[1];
            double grade = Double.parseDouble(stud[2]);
            students.add(new Students(id,name,grade));
//            System.out.printf("%-18s%-18s%-10s\n",id,name,grade);
        }
        while(true) {
            showmenu();
            System.out.println("Moi ban chon: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    students.add(addStudent(input));
                    index = students.size();
                    System.out.println("Them tanh cong sinh vien.");

                    break;
                case 2:
                        if(index != 0) {
                            FileWriter fileWriter = new FileWriter("phu.txt", true);
                            PrintWriter printWriter = new PrintWriter(fileWriter, true);
                            printWriter.println(students.get(index - 1).getId() + ";" + students.get(index - 1).getName() + ";" + students.get(index - 1).getGrade());
                            printWriter.close();
                            fileWriter.close();
                            System.out.println("Luu thanh cong");
                        } else {
                            System.out.println("Khong co du lieu moi");
                            System.out.println("Luu that bai");
                        }

                    break;
                case 3:
                    showMenu(students);
                    break;


            }
        }
    }

    public static void showMenu(ArrayList<Students> students) {
         System.out.printf("%-18s%-18s%-10s\n","Ma sinh vien","Ho va ten","Diem");
        for (var item :
                students) {
            showmenuLIST(item);
        }
    }

    public static void showmenuLIST(Students item) {
        System.out.printf("%-18s%-18s%-10s\n",item.getId(),item.getName(),item.getGrade());
    }

    public static Students addStudent(Scanner input) {
        System.out.println("Nhap ma sinh vien: ");
        String id = input.nextLine();
        System.out.println("Nhap ho va ten: ");
        String name = input.nextLine();
        System.out.println("Diem: ");
        double grade = input.nextDouble();

        return new Students(id,name,grade);
    }
    public static void showmenu() {
        System.out.println("1.them sinh vien");
        System.out.println("2.luu du lieu sinh vien vao file");
        System.out.println("3.Hien thi sinh vien ra man hinh.");
    }






}
