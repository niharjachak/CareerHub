package entity;

import java.sql.Timestamp;

public class JobApplications {
    private  int applicationId;
    private int jobId;
    private int applicantId;
    private Timestamp applicationDate;
    private String coverletter;


    public JobApplications(){}

    public JobApplications(int applicationId, int jobId, int applicantId,
                           Timestamp applicationDate, String coverletter) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.applicationDate = applicationDate;
        this.coverletter = coverletter;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCoverletter() {
        return coverletter;
    }

    public void setCoverletter(String coverletter) {
        this.coverletter = coverletter;
    }
}
