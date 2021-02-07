package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.StudentRequest;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.dto.response.StudentResponse;
import com.ims.sampleproject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Get a Student
     *
     * @param studentId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponse> getStudent(
            @PathVariable("id") Long studentId
    ) {
        logger.info("Get Student With Id :: {}", studentId);
        return ResponseEntity.ok(studentService.getOne(studentId));
    }

    /**
     * Get All Student
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity<Page<StudentResponse>> getAllStudent(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get Student List Page :: {}  Size :: {}", page, size);
        return ResponseEntity.ok(studentService.getAll(size, page));
    }

    /**
     * Add New Student
     *
     * @param studentRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> addStudent(
            @RequestBody StudentRequest studentRequest
    ) {
        studentService.add(studentRequest);
        logger.info("Add New Student Name :: {} Email :: {}", studentRequest.getFullName(), studentRequest.getEmail());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    /**
     * Update a Student
     *
     * @param studentId
     * @param studentRequest
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> updateStudent(
            @PathVariable("id") Long studentId,
            @RequestBody StudentRequest studentRequest
    ) {
        studentService.update(studentId, studentRequest);
        logger.info("Updated Student with Id :: {} ", studentId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    /**
     * Delete a Student
     *
     * @param studentId
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> deleteStudent(
            @PathVariable("id") Long studentId
    ) {
        studentService.delete(studentId);
        logger.info("Delete Student with Id :: {} ", studentId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
