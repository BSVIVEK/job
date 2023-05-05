# job

Job Management is a RESTful API built with Spring Boot and Hibernate that allows managing job postings and candidate applications for those jobs. This API provides the functionality to create, read, update and delete jobs, and candidates. 

The application supports authentication using Spring Security, and only authorized users can perform certain operations like creating and deleting jobs. 

This application uses an H2 in-memory database for storing job and candidate data. The data model consists of Job and Candidate entities, and a third entity named Application to represent the relationship between jobs and candidates. 

The API provides endpoints to fetch all jobs, all candidates, get details of a particular job or candidate, create a new job or candidate, and delete a job. It also supports the functionality to get all candidates who have applied for a specific job and all jobs applied by a particular candidate.
