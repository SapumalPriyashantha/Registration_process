package lk.ijse.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String studentAddress;
    private int studentPhoneNumber;


    @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<StudentDetails> studentDetails = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String studentName, String studentAddress, int studentPhoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public Student(String studentId, String studentName, String studentAddress, int studentPhoneNumber, List<StudentDetails> studentDetails) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentDetails = studentDetails;
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

    public List<StudentDetails> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<StudentDetails> studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPhoneNumber=" + studentPhoneNumber +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
