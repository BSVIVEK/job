CREATE TABLE Job (
                     job_id INT PRIMARY KEY,
                     title VARCHAR(255),
                     description TEXT,
                     location VARCHAR(255),
                     salary DECIMAL(10,2),
                     status VARCHAR(255)
);

CREATE TABLE Candidate (
                   id INT PRIMARY KEY,
                   name VARCHAR(255),
                   email VARCHAR(255),
                   phone VARCHAR(255),
                   resume TEXT,
                   job_id INT NULL,
                   FOREIGN KEY (job_id) REFERENCES Job(job_id)
);

#
# INSERT INTO Candidate (id, name, email, phone, resume, job_id)
# VALUES (1, 'John Smith', 'john.smith@email.com', '555-1234', 'Java developer with 5 years of experience', 1),
#        (2, 'Sarah Lee', 'sarah.lee@email.com', '555-5678', 'Data analyst with 3 years of experience', 2),
#        (3, 'David Kim', 'david.kim@email.com', '555-9101', 'Product manager with 7 years of experience', 3);
#
# INSERT INTO Job (job_id, title, description, location, salary, status)
# VALUES (1, 'Software Engineer', 'Develop software applications using Java', 'New York', 100000.00, 'Open'),
#        (2, 'Data Scientist', 'Analyze data and develop insights using Python', 'San Francisco', 120000.00, 'Closed'),
#        (3, 'Product Manager', 'Manage product development and launch', 'Seattle', 130000.00, 'Open');
#
#
#
#
#
# #
# # CREATE TABLE CANDID(
# #                      CANDID_ID BIGSERIAL PRIMARY KEY,
# #                      NAME VARCHAR(64) NOT NULL,
# #                      EMAILID VARCHAR(64) NOT NULL UNIQUE,
# #                      RESUME_HEADLINE VARCHAR(64) NOT NULL,
# #                      YRS_EX FLOAT NOT NULL
# # );
# #
# # CREATE TABLE JOB(
# #                       JOB_ID VARCHAR(64) PRIMARY KEY,
# #                       TITLE VARCHAR(64) NOT NULL ,
# #                       ORGANIZATION VARCHAR(64) NOT NULL ,
# #                       JOB_DESCRIPTION VARCHAR(64),
# #                       YRS_OF_EXPERIENCE_EXPECTED FLOAT NOT NULL ,
# #                       EMAILID VARCHAR(64) NOT NULL UNIQUE
# # );
# #
# #
# #
# # ALTER TABLE CANDID ADD FOREIGN KEY (CANDID_ID) REFERENCES JOB(JOB_ID);
# # ALTER TABLE JOB ADD FOREIGN KEY (JOB_ID) REFERENCES CANDID(CANDID_ID);
# # # CREATE INDEX IDX_RES_DATE_ ON RESERVATION(RES_DATE);
