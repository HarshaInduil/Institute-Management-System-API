package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.StudentRequest;
import com.ims.sampleproject.dto.response.StudentResponse;
import org.springframework.data.domain.Page;

public interface StudentService {

    /**
     * Get one Student By Id
     *
     * @param studentId
     * @return
     */
    StudentResponse getOne(Long studentId);

    /**
     * Get All Students
     *
     * @param size
     * @param page
     * @return
     */
    Page<StudentResponse> getAll(int size, int page);

    /**
     * Add Student
     *
     * @param studentRequest
     */
    void add(StudentRequest studentRequest);

    /**
     * Update Student
     *
     * @param studentId
     * @param studentRequest
     */
    void update(Long studentId, StudentRequest studentRequest);

    /**
     * Delete Student
     *
     * @param studentId
     */
    void delete(Long studentId);
}
