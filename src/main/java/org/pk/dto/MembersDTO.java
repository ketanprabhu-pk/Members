package org.pk.dto;

public class MembersDTO {
    private String usercode;
    private String name;
    private String jobs_completed;
    private String preffered_location;
    private Boolean inactive;
    // getters/setters, custom hashcode/equals

    public MembersDTO() {
    }

    public MembersDTO(String usercode, String name, String jobs_completed, String preffered_location, Boolean inactive) {
        this.usercode = usercode;
        this.name = name;
        this.jobs_completed = jobs_completed;
        this.preffered_location = preffered_location;
        this.inactive = inactive;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobs_completed() {
        return jobs_completed;
    }

    public void setJobs_completed(String jobs_completed) {
        this.jobs_completed = jobs_completed;
    }

    public String getPreferred_location() {
        return preffered_location;
    }

    public void setPreferred_location(String preffered_location) {
        this.preffered_location = preffered_location;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    public String disp() {
        return "user code='" + usercode + '\'' +
                ", name='" + name + '\'' +
                ", jobs_completed='" + jobs_completed + '\'' +
                ", preferred_location='" + preffered_location + '\'' +
                ", inactive=" + inactive;
    }
}
