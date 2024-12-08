
# Spring Boot REST API Documentation

This document explains how to implement and handle HTTP requests in a Spring Boot application using different HTTP methods: `GET`, `POST`, `PUT`, and `DELETE`. We'll use the example of managing student data.

## Table of Contents
1. [GET Request - Fetch Students](#get-request)
2. [POST Request - Upload Student](#post-request)
3. [PUT Request - Update Student](#put-request)
4. [DELETE Request - Delete Student](#delete-request)

---

## 1. GET Request - Fetch Students

### What is GET?

`GET` is used to retrieve data from the server. In this example, we'll retrieve a list of students.

### Controller Method

```java
@GetMapping("/stds")
List<Students> studentData() {
    return studentService.fetchStudents();
}
```

- **URL**: `/stds`
- **Method**: `GET`
- **Description**: Fetches the list of all students.

### Example Response

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "marks": 85,
    "domain": "Computer Science"
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "marks": 90,
    "domain": "Mathematics"
  }
]
```

---

## 2. POST Request - Upload Student

### What is POST?

`POST` is used to send data to the server to create a new resource. In this example, we'll add a new student to the list.

### Controller Method

```java
@PostMapping("/post")
String postStudents(@RequestBody Students std) {
    studentService.uploadStudent(std);
    return "Student uploaded with id: " + std.getId();
}
```

- **URL**: `/post`
- **Method**: `POST`
- **Description**: Uploads a new student.

### Example Request

```json
{
  "id": 3,
  "name": "Alice Johnson",
  "marks": 88,
  "domain": "Physics"
}
```

### Example Response

```text
Student uploaded with id: 3
```

---

## 3. PUT Request - Update Student

### What is PUT?

`PUT` is used to update an existing resource on the server. In this example, we'll update the details of a student based on their ID.

### Controller Method

```java
@PutMapping("update/{id}")
String updateStudentInfo(@PathVariable Long id, @RequestBody Students std) {
    studentService.updateStudent(id, std);
    return std.toString();
}
```

- **URL**: `/update/{id}`
- **Method**: `PUT`
- **Description**: Updates the details of a student.

### Example Request

```json
{
  "id": 1,
  "name": "Updated Name",
  "marks": 85,
  "domain": "Computer Science"
}
```

### Example Response

```text
Student updated successfully: Students{id=1, name='Updated Name', marks=85, domain='Computer Science'}
```

---

## 4. DELETE Request - Delete Student

### What is DELETE?

`DELETE` is used to remove a resource from the server. In this example, we'll delete a student from the list.

### Controller Method

```java
@DeleteMapping("/delete/{id}")
String deleteStudent(@PathVariable Long id) {
    if(studentService.deleteStudent(id))
        return "Deleted successfully";
    return "Student not found";
}
```

- **URL**: `/delete/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a student based on the provided ID.

### Example Request

```text
DELETE http://localhost:8080/delete/1
```

### Example Response

```text
Deleted successfully
```

---

## Key Concepts

- **@GetMapping**: Used to map HTTP GET requests to a handler method that retrieves resources (in this case, a list of students).
- **@PostMapping**: Used to map HTTP POST requests to a handler method that creates a new resource (in this case, uploading a student).
- **@PutMapping**: Used to map HTTP PUT requests to a handler method that updates an existing resource (in this case, updating student details).
- **@DeleteMapping**: Used to map HTTP DELETE requests to a handler method that deletes a resource (in this case, removing a student).
- **@PathVariable**: Extracts variables from the URI, such as the student ID.
- **@RequestBody**: Binds the incoming request body (in JSON format) to a Java object.

---

## Troubleshooting

- If a request does not return the expected result, ensure the URL is correct and that the request body is properly formatted (for POST and PUT).
- For PUT and DELETE requests, check if the correct ID is passed in the URL as a path variable.

---

This document provides a guide to handling common HTTP requests in a Spring Boot application with examples for GET, POST, PUT, and DELETE methods.
