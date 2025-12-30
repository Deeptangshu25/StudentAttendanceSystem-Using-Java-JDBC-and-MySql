

Student Attendance Management System

A console-based Student Attendance Management System developed using Core Java, JDBC, and MySQL.  
This project simulates a real-world backend system for managing students and their daily attendance with proper authentication, validation, and database integrity.



 📌 Project Overview

The system allows authenticated users to manage student records and mark attendance efficiently.  
It demonstrates strong fundamentals of Java programming, database connectivity, and SQL constraint handling, making it suitable for learning and real-world backend development practice.



 ✨ Features

- User authentication (login-based access)
- Add, view, and delete student records
- Mark attendance using P (Present) or A (Absent)
- Automatic system date capture for attendance
- Validation for delete operations (handles non-existent records)
- Relational database design with foreign key constraints
- Clean menu-driven console interface
- Robust error handling and input validation



 🛠️ Tech Stack

- Language: Java  
- Database: MySQL  
- Connectivity: JDBC  
- Build Tool: Command-line (javac, java)  
- Version Control: Git & GitHub  



 🗂️ Project Structure



StudentAttendanceSystem/
├── src/
│   ├── DBConnection.java
│   ├── UserLogin.java
│   ├── Student.java
│   ├── Attendance.java
│   └── MainMenu.java
├── lib/
│   └── mysql-connector-j-9.5.0.jar
├── README.md
└── .gitignore





 🗄️ Database Schema

 Students Table
- student_id (Primary Key)
- name
- roll_no
- course

 Attendance Table
- attendance_id (Primary Key)
- student_id (Foreign Key)
- date
- status

Foreign key constraints ensure referential integrity between students and attendance records.



 ▶️ How to Run the Project

 1️⃣ Clone the repository
bash
git clone https://github.com/YOUR_USERNAME/student-attendance-system.git
cd student-attendance-system


 2️⃣ Set up the database

 Create a MySQL database
 Execute the SQL scripts to create required tables
 Insert an initial admin user

 3️⃣ Configure database credentials

Update DBConnection.java:

java
private static final String USER = "root";
private static final String PASS = "YOUR_MYSQL_PASSWORD";


 4️⃣ Compile and run

bash
javac -cp "lib/mysql-connector-j-9.5.0.jar" src/.java
java -cp "lib/mysql-connector-j-9.5.0.jar;src" MainMenu




 🧠 Key Learnings

 JDBC-based database connectivity
 SQL constraints and foreign key handling
 Difference between DELETE and TRUNCATE
 Safe update mode in MySQL
 Real-world ID management logic
 Input stream handling in Java
 Error handling and validation techniques



 🚀 Future Enhancements

 GUI using Java Swing or JavaFX
 Web-based frontend using Next.js + TypeScript
 REST API backend using Java Servlets or Spring Boot
 Attendance reports and analytics
 Role-based authentication
 Password hashing and security improvements



 👤 Author

Deeptangshu Sen
B.Tech (CSE)
Aspiring Software Engineer



 📄 License

This project is for learning and educational purposes.


