package lk.ijse.hibernate.entity.TM;

public class StudentdetailsView {
    private String studentId;
    private String studentName;
    private int studentPhoneNumber;
    private String programmeName;
    private String registrationDate;

    public StudentdetailsView() {
    }

    public StudentdetailsView(String studentId, String studentName, int studentPhoneNumber, String programmeName, String registrationDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhoneNumber = studentPhoneNumber;
        this.programmeName = programmeName;
        this.registrationDate = registrationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(int studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "studentdetailsView{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPhoneNumber=" + studentPhoneNumber +
                ", programmeName='" + programmeName + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
