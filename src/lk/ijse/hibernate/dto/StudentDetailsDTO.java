package lk.ijse.hibernate.dto;

import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;

public class StudentDetailsDTO {
    private String programme_id;
    private String student_id;
    private String registrationDate;

    public StudentDetailsDTO() {
    }

    public StudentDetailsDTO(String programme_id, String student_id, String registrationDate) {
        this.programme_id = programme_id;
        this.student_id = student_id;
        this.registrationDate = registrationDate;
    }

    public String getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(String programme_id) {
        this.programme_id = programme_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "StudentDetailsDTO{" +
                "programme_id='" + programme_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
