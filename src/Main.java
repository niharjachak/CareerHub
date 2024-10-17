import dao.DatabaseManagerImpl;
import dao.DatabaseManagerdao;
import entity.Applicants;
import entity.JobApplications;
import entity.JobListing;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to CareerHub !!\nFeatures:");
            System.out.println("1. Applicant Profile Creation");
            System.out.println("2. Job Listing Retrieval");
            System.out.println("3. Job Application Submission");
            System.out.println("4. Company Job Posting");
            System.out.println("5. Salary Range Query");
            System.out.println("6. Exit");
            System.out.print("Enter your Choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    DatabaseManagerdao dm = new DatabaseManagerImpl();
                    try {
                        // User input for applicant details
                        System.out.print("Enter Applicant ID: ");
                        int applicantId = scan.nextInt();
                        System.out.print("Enter First Name: ");
                        String firstName = scan.next();
                        System.out.print("Enter Last Name: ");
                        String lastName = scan.next();
                        System.out.print("Enter Email: ");
                        String email = scan.next();
                        System.out.print("Enter Phone: ");
                        String phone = scan.next();
                        System.out.print("Enter Resume: ");
                        String resumeLink = scan.next();

                        // Create an Applicant object
                        Applicants a = new Applicants(applicantId, firstName, lastName, email, phone, resumeLink);
                        dm.insertApplicant(a);
                        System.out.println("Insertion Successful");

                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                case 2: {
                    DatabaseManagerdao dm = new DatabaseManagerImpl();
                    try {
                        List<JobListing> jl = dm.getJobListing();
                        for (JobListing j : jl) {
                            System.out.println(j);  // Print the JobListing object directly
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    DatabaseManagerdao dm = new DatabaseManagerImpl();
                    try {
                        // User input for job application details
                        System.out.print("Enter Application ID: ");
                        int applicationId = scan.nextInt();
                        System.out.print("Enter Job ID: ");
                        int jobId = scan.nextInt();
                        System.out.print("Enter Applicant ID: ");
                        int applicantId = scan.nextInt();
                        System.out.print("Enter Application Date (YYYY-MM-DD): ");
                        String dateString = scan.next();
                        dateString += " 00:00:00";  // Add default time part

                        Timestamp applicationDate = Timestamp.valueOf(dateString);
                        System.out.print("Enter Cover Letter Link: ");
                        String coverLetter = scan.next();

                        // Create a JobApplications object
                        JobApplications ja = new JobApplications(applicationId, jobId, applicantId, applicationDate, coverLetter);
                        dm.insertJobApplications(ja);
                        System.out.println("Job Application Submitted Successfully");
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    DatabaseManagerImpl dm = new DatabaseManagerImpl();
                    try {
                        Scanner input = new Scanner(System.in);

                        System.out.print("Enter Job ID: ");
                        int jobId = input.nextInt();
                        System.out.print("Enter Company ID: ");
                        int companyId = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Job Title: ");
                        String jobTitle = input.nextLine();
                        System.out.print("Enter Job Description: ");
                        String jobDescription = input.nextLine();
                        System.out.print("Enter Job Location: ");
                        String jobLocation = input.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = input.nextDouble();
                        input.nextLine(); // Consume newline
                        System.out.print("Enter Job Type: ");
                        String jobType = input.nextLine();


                        Timestamp postedDate = new Timestamp(System.currentTimeMillis()); // Set current timestamp
                        // Create a new JobListing object
                        JobListing newJobListing = new JobListing(jobId, companyId, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate);

                        // Insert the new job listing into the database
                        dm.insertJobListing(newJobListing);
                        System.out.println("Job posting successful!");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5: {
                    DatabaseManagerdao dm = new DatabaseManagerImpl();
                    try {
                        System.out.print("Enter Minimum Salary: ");
                        double minSalary = scan.nextDouble();
                        System.out.print("Enter Maximum Salary: ");
                        double maxSalary = scan.nextDouble();

                        List<JobListing> jobsInRange = dm.getSalaryInRange(minSalary, maxSalary);
                        for (JobListing job : jobsInRange) {
                            System.out.println(job);  // Print the JobListing object directly
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Enter a correct choice");
                    break;
                }
            }
        } while (choice != 6);

        scan.close();  // Close the scanner to avoid resource leaks
    }
}
