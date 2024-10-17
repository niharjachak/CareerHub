package dao;

import entity.Applicants;
import entity.Companies;
import entity.JobApplications;
import entity.JobListing;
import util.DatabaseConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManagerImpl implements DatabaseManagerdao{
    @Override
    public List<Applicants> getApplicants() throws SQLException {
        List<Applicants> applicants = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        try{
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM  Applicants");
            while(rs.next()){
                Applicants app = new Applicants(
                        rs.getInt("applicant_id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("resume")
                );
                applicants.add(app);
            }
            return applicants;
        }catch (SQLException s){
            s.printStackTrace();
        }
        return new ArrayList<>(null);
    }

    @Override
    public void insertApplicant(Applicants applicants) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Applicants VALUES(?,?,?,?,?,?)");
            pstmt.setInt(1,applicants.getApplicantID());
            pstmt.setString(2,applicants.getFirstName());
            pstmt.setString(3,applicants.getLastName());
            pstmt.setString(4, applicants.getEmail());
            pstmt.setString(5,applicants.getPhone());
            pstmt.setString(6,applicants.getResume());
            int rowsAffected = pstmt.executeUpdate(); // Execute the insertion
            if (rowsAffected > 0) {
                System.out.println("Applicant inserted successfully.");
            } else {
                System.out.println("Failed to insert applicant.");
            }
        }catch (SQLException s ){
            s.printStackTrace();
        }

    }

    @Override
    public List<Companies> getCompanies() throws SQLException {

        List<Companies> companies = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        try{
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM Companies");
            while(rs.next()){
                Companies c = new Companies(
                        rs.getInt("company_id"),
                        rs.getString("companyname"),
                        rs.getString("cloc")
                );
                companies.add(c);
            }
            return companies;

        }catch(SQLException s){
            s.printStackTrace();
        }
        return new ArrayList<>(null);
    }

    @Override
    public void insertCompanies(Companies companies) throws  SQLException {

        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO COMPANIES VALUES(?,?,?)");
            pstmt.setInt(1,companies.getCompanyId());
            pstmt.setString(2,companies.getCompanyName());
            pstmt.setString(3,companies.getLocation());

        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    @Override
    public List<JobListing> getJobListing() throws  SQLException {

        List<JobListing> joblistings= new ArrayList<>();
        String sql = "SELECT job_id, company_id, job_title, job_desc, jloc, salary, job_type, posted_date FROM Jobs";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){


            while(rs.next()){
                JobListing j= new JobListing(
                        rs.getInt("job_id"),
                        rs.getInt("company_id"),
                        rs.getString("job_title"),
                        rs.getString("job_desc"),
                        rs.getString("jloc"),
                        rs.getDouble("salary"),
                        rs.getString("job_type"),
                        rs.getTimestamp("posted_date")
                );
                joblistings.add(j);
            }
            return joblistings;
        }catch (SQLException s){
        }
        return  new ArrayList<>(null);
    }

    @Override
    public void insertJobListing(JobListing jobListing) throws ClassNotFoundException, SQLException {

        Connection conn = DatabaseConnection.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO jobs VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setInt(1,jobListing.getJobid());
            pstmt.setInt(2,jobListing.getCompanyid());
            pstmt.setString(3,jobListing.getJobTitle());
            pstmt.setString(4,jobListing.getJobDescription());
            pstmt.setString(5,jobListing.getJobLocation());
            pstmt.setDouble(6,jobListing.getSalary());
            pstmt.setString(7,jobListing.getJobtype());
            pstmt.setTimestamp(8,jobListing.getPostedDate());

            pstmt.executeUpdate();
        }catch(SQLException s){
            s.printStackTrace();
        }
    }

    @Override
    public List<JobApplications> getJobApplications(int id) throws  SQLException {
        List<JobApplications>jobApplications = new ArrayList<>();

        Connection conn = DatabaseConnection.getConnection();
        try{
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Applications WHERE job_id= ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,id);

            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                JobApplications jobApps = new JobApplications(
                        rs.getInt("application_id"),
                        rs.getInt("job_id"),
                        rs.getInt("applicant_id"),
                        rs.getTimestamp("application_date"),
                        rs.getString("coverletter")
                );
                jobApplications.add(jobApps);
            }
            return jobApplications;

        }catch(SQLException s){
            s.printStackTrace();
        }

        return new ArrayList<>(null);
    }

    @Override
    public void insertJobApplications(JobApplications jobApplications) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement st = null;

    try{
        String sql = "INSERT INTO Applications VALUES(?,?,?,?,?)";
        st = conn.prepareStatement(sql);

        st.setInt(1,jobApplications.getApplicationId());
        st.setInt(2,jobApplications.getJobId());
        st.setInt(3,jobApplications.getApplicantId());
        st.setTimestamp(4,jobApplications.getApplicationDate());
        st.setString(5,jobApplications.getCoverletter());

        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Job Application inserted successfully!");
        } else {
            System.out.println("Job Application insertion failed.");
        }

        }catch (SQLException s){
        s.printStackTrace();
    }
    }

    @Override
    public List<JobListing> getSalaryInRange(double minsalary, double maxsalary) throws SQLException {
                    List <JobListing> jobListings = new ArrayList<>();
                    String sql = "SELECT j.job_id, j.job_title, c.companyname, j.salary " +
                            " FROM Jobs j  " +
                            " JOIN Companies c ON j.company_id = c.company_id " +
                            " WHERE j.salary BETWEEN ? AND ?";

                    try(Connection conn = DatabaseConnection.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql)){
                        pstmt.setDouble(1,minsalary);
                        pstmt.setDouble(2,maxsalary);

                        ResultSet rs = pstmt.executeQuery();
                        while (rs.next()){
                            int jobId= rs.getInt("job_id");
                            String jobTitle= rs.getString("job_title");
                            String companyname= rs.getString("companyname");
                            double salary = rs.getDouble("salary");

                            System.out.println("Job ID: " + jobId + ", Job Title: " + jobTitle + ", Company: " + companyname + ", Salary: " + salary);
                        }

        }
        return jobListings;
    }
}

