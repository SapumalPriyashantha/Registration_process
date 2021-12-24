package lk.ijse.hibernate.dto;

public class StudentDTO {
    private String studentId;
    private String studentName;
    private String studentAddress;
    private int studentPhoneNumber;

    public StudentDTO() {
    }

    public StudentDTO(String studentId, String studentName, String studentAddress, int studentPhoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentPhoneNumber = studentPhoneNumber;
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

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(int studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPhoneNumber=" + studentPhoneNumber +
                '}';
    }
}
