package lk.ijse.hibernate.entity;

import javax.persistence.*;

@Entity
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Programme programme;
    @ManyToOne
    @JoinColumn
    private Student student;

    private String registrationDate;

    public StudentDetails() {
    }

    public StudentDetails(Programme programme, Student student, String registrationDate) {
        this.programme = programme;
        this.student = student;
        this.registrationDate = registrationDate;
    }

    public StudentDetails(int id, Programme programme, Student student, String registrationDate) {
        this.id = id;
        this.programme = programme;
        this.student = student;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", programme=" + programme +
                ", student=" + student +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
