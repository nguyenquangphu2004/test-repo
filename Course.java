import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    public static int indexidCourse = 0;

    public static String idStr = "COU";
    public static int idnNub = 1001;
    private String id;
    private String name;
    private String roomClass;
    private String time;
    private Subject subject;
    private ArrayList<GradeofStudent> gradeofStudents;


    public Course() {
        id = "";
        name = "";
        roomClass = "";
        time = "";
        subject = null;
        gradeofStudents = new ArrayList<>();

    }

    public Course(String id, String name, String roomClass, String time, Subject subject,ArrayList<GradeofStudent> gradeofStudents) {
        this.id = id;
        this.name = name;
        this.roomClass = roomClass;
        this.time = time;
        this.subject = subject;
        this.gradeofStudents = new ArrayList<>();
        this.gradeofStudents = gradeofStudents;

    }

    public Course(String id, String name, String roomClass, String time, Subject subject) {
        this.id = id;
        this.name = name;
        this.roomClass = roomClass;
        this.time = time;
        this.subject = subject;

    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = idStr + idnNub;
        idnNub ++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ArrayList<GradeofStudent> getGradeofStudents() {
        return gradeofStudents;
    }

    public void setGradeofStudents(Student student,Grade grade) {
        for(int i = 0; i < gradeofStudents.size(); i++) {
            if(student.getId().compareTo(gradeofStudents.get(i).getStudent().getId()) == 0 )
                grade = gradeofStudents.get(i).getGrade() ;
        }
    }




    public  void showCourse(ArrayList<Course> courses) {
        System.out.println(courses.get(0).getSubject().getId());
        System.out.printf("%-10s %-18s %-10s %-10s %-10s\n","Mã Lớp","Tên Của Khóa","Phòng Học","Giờ Học","Mã Môn Học");
        for (var item :
                courses) {
            showmenu(item);


        }
    }
    public void showmenu(Course item) {
        System.out.printf("%-10s %-18s %-10s %-10s %-10s\n",item.getId(),item.getName(),item.getTime(),item.getTime(),item.getSubject().getId());
    }

    public  Course addCourse(ArrayList<Subject> subjects, Scanner input) {
        if(RunCode.countCourse != 0) {
            System.out.println("Mã lớp học: ");
            setId();
            String id = getId();
            System.out.println(id);
            System.out.println("Tên lớp: ");
            String name = input.nextLine();

            System.out.println("Phòng học: ");
            String room = input.nextLine();

            System.out.println("Giờ học: ");
            String time = input.nextLine();

            System.out.println("Mã môn học: ");
            String idS = input.nextLine();
            var subjectk = RunCode.subject.findSubject(idS,subjects);
            if(subjectk != null) {

                System.out.println("Thêm lớp thành công");
                return new Course(id,name,room,time,subjectk);
            } else {
                System.out.println("Mã môn học không hợp lệ");
                System.out.println("Thêm lớp thất bại.");
                return  null;
            }


        } else {
            System.out.println("Môn học rỗng");
            System.out.println("Thêm lớp thất bại");
            return  null;
        }
    }



    public void setCourse(Scanner input,ArrayList<Course> courses,Subject subject,ArrayList<Subject> subjects) {
        System.out.println("Nhập mã lớp học: ");
        String idC = input.nextLine();
        var course = findCourseId(idC, courses);
        if (course != null) {
                boolean check = true;
                while (check) {
                    showMenuCourse();
                    int choice = input.nextInt();
                    input.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập tên lớp: ");
                            String name = input.nextLine();
                            courses.get(RunCode.index).setName(name);
                            System.out.println("Sửa lớp thành cong");
                            break;
                        case 2:
                            System.out.println("Nhập tên phong: ");
                            String room = input.nextLine();
                            courses.get(RunCode.index).setRoomClass(room);
                            System.out.println("Sửa phòng thành công");
                            break;
                        case 3:
                            System.out.println("Nhập thời gian: ");
                            String time = input.nextLine();
                            courses.get(RunCode.index).setTime(time);
                            System.out.println("Sửa thời gian thành công");
                            break;
                        case 4:
                            System.out.println("Nhập mã môn học: ");
                            String idS = input.nextLine();
                            var sub = RunCode.subject.findSubject(idS, subjects);
                            if(sub != null) {
                                courses.get(RunCode.index).getSubject().setId(idS);
                                System.out.println("Sửa mã thành công");
                            } else {
                                System.out.println("Sửa mã thất bại.");
                            }
                            break;
                        default:
                            System.out.println("Không hợp lệ.");
                            check = false;
                    }
                }
        } else {
            System.out.println("Mã lớp không hợp lệ or không tồn tại.");
            System.out.println("Sửa thất bại.");
        }
    }



    public Course findCourseId(String idC, ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            if(idC.compareTo(courses.get(i).getId()) == 0) {
                indexidCourse = i;
                return courses.get(i);
            }
        }
        return null;
    }


    public void showMenuCourse() {
        System.out.println("1.Sửa tên lớp học.");
        System.out.println("2.Sửa tên phòng học.");
        System.out.println("3.Sửa mốc thời gian học.");
        System.out.println("4.Sửa mã môn học.");
        System.out.println("Mời bạn chọn: ");
    }









    public class  GradeofStudent {
        private Student student;
        private Grade grade;

        public GradeofStudent(Student student, Grade grade) {
            this.student = student;
            this.grade = grade;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Grade getGrade() {
            return grade;
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }
    }



}


