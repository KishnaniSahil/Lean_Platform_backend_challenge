-- Create Database
CREATE DATABASE consulting_app_db;



-- Create Schema
CREATE SCHEMA consulting_app_schema;


-- Assuming you already have a consultant table and mentor_request table




-- Create Mentor Table
CREATE TABLE consulting_app_schema.mentor (
    mid int identity(1,1) PRIMARY KEY,
    mentor_name VARCHAR(255) NOT NULL,
    age INT,
    phone_no VARCHAR(20),
	role VARCHAR(50),
    -- Add other details as needed
);



-- Create Consultant Table
CREATE TABLE consulting_app_schema.consultant (
    cid int identity(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    phone_no VARCHAR(20),
    email VARCHAR(255) NOT NULL,
    job_role VARCHAR(100),
    cv Varchar(20),
    -- Add other details as needed
);


-- Create MentorRequest Table
CREATE TABLE consulting_app_schema.mentor_request (
    mr_id int identity(1,1) PRIMARY KEY,
    consultant_name VARCHAR(255) NOT NULL,
	mentor_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
	Sessionbooked bit DEFAULT 0,
	client_id int FOREIGN KEY REFERENCES consulting_app_schema.consultant(cid),
	mentor_id int FOREIGN KEY REFERENCES consulting_app_schema.mentor(mid),


    -- Add other details as needed
);
