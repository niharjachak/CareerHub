create database if not exists Careerhub;
use Careerhub;


create table Companies ( 
	company_id int  primary key auto_increment ,
	companyname varchar(50), 
	cloc varchar(50) 
    );

    
create table jobs ( job_id int primary key , 
	company_id int ,
    job_title varchar(50), 
	job_desc text,
    jloc varchar(50),
    salary decimal , 
    job_type varchar(50),
    posted_date datetime, 
    foreign key (company_id) references Companies(company_id)
    );

 
create table Applicants (
	applicant_id int primary key ,
    fname varchar(50),
    lname varchar(50),
    email varchar (50),
    phone varchar (30),
    resume text
    );

    
create table Applications ( application_id int primary key auto_increment,
	job_id int,
    applicant_id int,
    application_date datetime,
    coverletter text,
    foreign key (job_id) references Jobs(job_id),
    foreign key (applicant_id) references Applicants(applicant_id)
    );
    
    -- Insert  data into Companies table
INSERT INTO Companies ( CompanyName, cloc) VALUES 
('NextGen Solutions', 'Austin'),
('Digital Media Corp.', 'New York'),
('Elite Logistics', 'Chicago'),
('Bright Future Consulting', 'Los Angeles'),
('SafeTech Security', 'San Francisco'),
('Smart Homes Inc.', 'Seattle'),
('TravelXperience', 'Miami'),
('AI Innovations', 'Boston'),
('HealthTech Labs', 'Denver'),
('Retail Connect', 'Phoenix');

-- Insert additional data into Jobs table
INSERT INTO Jobs (job_id,company_id, job_title, job_desc, jloc, salary, job_type, posted_date) VALUES 
(001,1, 'Cloud Engineer', 'Design and manage cloud-based infrastructure.', 'Austin', 95000.00, 'Full-time', NOW()),
(002,2, 'Content Writer', 'Create engaging content for various platforms.', 'New York', 60000.00, 'Part-time', NOW()),
(003,3, 'Supply Chain Manager', 'Oversee supply chain operations and logistics.', 'Chicago', 80000.00, 'Full-time', NOW()),
(004,4, 'Business Analyst', 'Analyze business needs and provide solutions.', 'Los Angeles', 85000.00, 'Full-time', NOW()),
(005,5, 'Cybersecurity Analyst', 'Protect company data from cyber threats.', 'San Francisco', 100000.00, 'Full-time', NOW()),
(006,6, 'IoT Developer', 'Develop applications for smart home devices.', 'Seattle', 105000.00, 'Full-time', NOW()),
(007,7, 'Travel Consultant', 'Plan and book travel itineraries for clients.', 'Miami', 50000.00, 'Full-time', NOW()),
(008,8, 'Machine Learning Engineer', 'Develop machine learning models and algorithms.', 'Boston', 110000.00, 'Full-time', NOW()),
(009,9, 'Laboratory Technician', 'Conduct tests and analyze medical samples.', 'Denver', 70000.00, 'Full-time', NOW()),
(010,10, 'E-commerce Manager', 'Manage online retail operations and strategies.', 'Phoenix', 90000.00, 'Full-time', NOW());

-- Insert additional data into Applicants table
INSERT INTO Applicants (applicant_id,fname, lname, email, phone, resume) VALUES 
(1001,'Chris', 'Lee', 'chris.lee@example.com', '012-345-6789', 'Resume content here...'),
(1002,'Jessica', 'Taylor', 'jessica.taylor@example.com', '123-456-7890', 'Resume content here...'),
(1003,'Daniel', 'Anderson', 'daniel.anderson@example.com', '234-567-8901', 'Resume content here...'),
(1004,'Megan', 'Thomas', 'megan.thomas@example.com', '345-678-9012', 'Resume content here...'),
(1005,'Andrew', 'Jackson', 'andrew.jackson@example.com', '456-789-0123', 'Resume content here...'),
(1006,'Sophie', 'White', 'sophie.white@example.com', '567-890-1234', 'Resume content here...'),
(1007,'Liam', 'Harris', 'liam.harris@example.com', '678-901-2345', 'Resume content here...'),
(1008,'Olivia', 'Martin', 'olivia.martin@example.com', '789-012-3456', 'Resume content here...'),
(1009,'Ethan', 'Thompson', 'ethan.thompson@example.com', '890-123-4567', 'Resume content here...'),
(1010,'Ava', 'Garcia', 'ava.garcia@example.com', '901-234-5678', 'Resume content here...');

-- Insert additional data into Applications table
INSERT INTO Applications (job_id, applicant_id, application_date, coverletter) VALUES 
(1, 1001, NOW(), 'I am eager to contribute to cloud engineering projects.'),
(2, 1002, NOW(), 'I am passionate about content creation and storytelling.'),
(3, 1003, NOW(), 'I have extensive experience in supply chain management.'),
(4, 1004, NOW(), 'I am excited to help improve business processes.'),
(5, 1005, NOW(), 'I have a strong background in cybersecurity.'),
(6, 1006, NOW(), 'I am interested in developing IoT applications.'),
(7, 1007, NOW(), 'I love helping people plan their travel adventures.'),
(8, 1008, NOW(), 'I am skilled in machine learning and data analysis.'),
(9, 1009, NOW(), 'I have experience as a laboratory technician.'),
(10, 1010, NOW(), 'I am eager to drive e-commerce success.');


select * from Companies;
select * from jobs;
select * from applicants;
select * from applications;

