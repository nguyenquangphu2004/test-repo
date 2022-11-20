public class Grade {
    private String id;
    private double grade1;
    private double grade2;
    private double grade3;
    private  double avrGrade;
    private Study study;

    public Grade() {
        id ="";
        grade1=0;
        grade2=0;
        grade3=0;
        avrGrade=0;
        study = null;

    }

    public Grade(String id, double grade1, double grade2, double grade3, double avrGrade, Study study) {
        this.id = id;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.avrGrade = avrGrade;
        this.study = study;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public double getAvrGrade() {
        return avrGrade;
    }

    public void setAvrGrade(double avrGrade) {
        this.avrGrade = (getGrade1() + 2 * getGrade2() + 3 * getAvrGrade()) / 6;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }



//    public void studentStudy() {
//        this.study =
//    }






}
