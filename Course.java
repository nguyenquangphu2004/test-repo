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
        System.out.printf("%-10s %-18s %-10s %-10s %-10s\n","M?? L???p","T??n C???a Kh??a","Ph??ng H???c","Gi??? H???c","M?? M??n H???c");
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
            System.out.println("M?? l???p h???c: ");
            setId();
            String id = getId();
            System.out.println(id);
            System.out.println("T??n l???p: ");
            String name = input.nextLine();

            System.out.println("Ph??ng h???c: ");
            String room = input.nextLine();

            System.out.println("Gi??? h???c: ");
            String time = input.nextLine();

            System.out.println("M?? m??n h???c: ");
            String idS = input.nextLine();
            var subjectk = RunCode.subject.findSubject(idS,subjects);
            if(subjectk != null) {

                System.out.println("Th??m l???p th??nh c??ng");
                return new Course(id,name,room,time,subjectk);
            } else {
                System.out.println("M?? m??n h???c kh??ng h???p l???");
                System.out.println("Th??m l???p th???t b???i.");
                return  null;
            }


        } else {
            System.out.println("M??n h???c r???ng");
            System.out.println("Th??m l???p th???t b???i");
            return  null;
        }
    }



    public void setCourse(Scanner input,ArrayList<Course> courses,Subject subject,ArrayList<Subject> subjects) {
        System.out.println("Nh???p m?? l???p h???c: ");
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
                            System.out.println("Nh???p t??n l???p: ");
                            String name = input.nextLine();
                            courses.get(RunCode.index).setName(name);
                            System.out.println("S???a l???p th??nh cong");
                            break;
                        case 2:
                            System.out.println("Nh???p t??n phong: ");
                            String room = input.nextLine();
                            courses.get(RunCode.index).setRoomClass(room);
                            System.out.println("S???a ph??ng th??nh c??ng");
                            break;
                        case 3:
                            System.out.println("Nh???p th???i gian: ");
                            String time = input.nextLine();
                            courses.get(RunCode.index).setTime(time);
                            System.out.println("S???a th???i gian th??nh c??ng");
                            break;
                        case 4:
                            System.out.println("Nh???p m?? m??n h???c: ");
                            String idS = input.nextLine();
                            var sub = RunCode.subject.findSubject(idS, subjects);
                            if(sub != null) {
                                courses.get(RunCode.index).getSubject().setId(idS);
                                System.out.println("S???a m?? th??nh c??ng");
                            } else {
                                System.out.println("S???a m?? th???t b???i.");
                            }
                            break;
                        default:
                            System.out.println("Kh??ng h???p l???.");
                            check = false;
                    }
                }
        } else {
            System.out.println("M?? l???p kh??ng h???p l??? or kh??ng t???n t???i.");
            System.out.println("S???a th???t b???i.");
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
        System.out.println("1.S???a t??n l???p h???c.");
        System.out.println("2.S???a t??n ph??ng h???c.");
        System.out.println("3.S???a m???c th???i gian h???c.");
        System.out.println("4.S???a m?? m??n h???c.");
        System.out.println("M???i b???n ch???n: ");
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


