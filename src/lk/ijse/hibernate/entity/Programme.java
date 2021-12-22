package lk.ijse.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Programme {
    @Id
    private String programmeId;
    private String programmeName;
    private double duration;
    private double fee;

    @OneToMany(mappedBy = "programme" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<StudentDetails> studentDetails = new ArrayList<>();

    public Programme() {
    }

    public Programme(String programmeId, String programmeName, double duration, double fee) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
    }

    public Programme(String programmeId, String programmeName, double duration, double fee, List<StudentDetails> studentDetails) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
        this.studentDetails = studentDetails;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<StudentDetails> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<StudentDetails> studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "programmeId='" + programmeId + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
