package entity;

import java.sql.Timestamp;

public class JobListing {
    private int jobid;
    private int companyid;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private  double salary ;
    private String jobtype;
    private Timestamp postedDate;

    public JobListing(int jobId, int companyId, String jobDesc, String jloc, double salary, String jobType, Timestamp postedDate){

    }
    public JobListing(int jobid, int companyid, String jobTitle,
                      String jobDescription, String jobLocation, double salary,
                      String jobtype, Timestamp postedDate) {
        this.jobid = jobid;
        this.companyid = companyid;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.salary = salary;
        this.jobtype = jobtype;
        this.postedDate =  postedDate;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "[" +
                "JobId=" + jobid +
                ", CompanyID=" + companyid +
                ", JobTitle='" + jobTitle + '\'' +
                ", JobDesc='" + jobDescription + '\'' +
                ", Location='" + jobLocation + '\'' +
                ", salary=" + salary +
                ", JobType='" + jobtype + '\'' +
                ", Posted Date=" + postedDate +
                ']';
    }
}
