package dao;

import entity.Applicants;
import entity.Companies;
import entity.JobApplications;
import entity.JobListing;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseManagerdao {
    List<Applicants> getApplicants() throws ClassNotFoundException, SQLException;

    public void insertApplicant(Applicants applicants)throws ClassNotFoundException, SQLException;

    List<Companies> getCompanies()throws ClassNotFoundException, SQLException;

    public void insertCompanies(Companies companies)throws ClassNotFoundException, SQLException;

    List<JobListing> getJobListing()throws ClassNotFoundException, SQLException;

    public void insertJobListing(JobListing jobListing)throws ClassNotFoundException, SQLException;

    List<JobApplications> getJobApplications(int id)throws ClassNotFoundException, SQLException;

    public void insertJobApplications(JobApplications jobApplications)throws ClassNotFoundException, SQLException;

    List <JobListing> getSalaryInRange(double minsalary , double maxsalary)throws ClassNotFoundException, SQLException;

}
