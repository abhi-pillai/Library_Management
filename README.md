
# Library Management System

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Classes](#classes)
- [How to Run](#how-to-run)
- [Usage](#usage)

## Overview

A Java-based Library Management System that allows students to borrow and return books while maintaining an inventory of available books.

## Features

- 📚 Add new books to the library
- 👤 Register students
- 🔍 Search books by serial number or name
- 📤 Check out books
- 📥 Check in books
- 📋 View all books and students

## Project Structure

```
Library_Management/
├── Book.java
├── Books.java
├── Student.java
├── Students.java
├── Library.java
└── README.md
```

## Classes

### Book
Represents a single book with serial number, name, author, and quantity tracking.

### Books
Manages the collection of books with search and checkout functionality.

### Student
Stores student information and tracks borrowed books (max 3).

### Students
Manages student registration and book borrowing operations.

### Library
Main application class with menu-driven interface.

## How to Run

```bash
javac Library_Management/*.java
java Library_Management.Library
```

## Usage

Select options from the menu:
1. Add Book
2. Register Student
3. Show All Books
4. Search Book
5. Checkout Book
6. Checkin Book
7. List All Students
8. Exit

## Credits
This project is part of the **GeeksForGeeks NationSkillUp** program.


[↑ Back to top](#library-management-system)
