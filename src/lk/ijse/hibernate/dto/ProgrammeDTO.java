package lk.ijse.hibernate.dto;

public class ProgrammeDTO {
    private String programmeId;
    private String programmeName;
    private double duration;
    private double fee;

    public ProgrammeDTO() {
    }

    public ProgrammeDTO(String programmeId, String programmeName, double duration, double fee) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.duration = duration;
        this.fee = fee;
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

    @Override
    public String toString() {
        return "ProgrammeDTO{" +
                "programmeId='" + programmeId + '\'' +
                ", programmeName='" + programmeName + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                '}';
    }
}
