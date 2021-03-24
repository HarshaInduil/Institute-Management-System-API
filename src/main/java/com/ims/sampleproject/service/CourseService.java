package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.CourseRequest;
import com.ims.sampleproject.dto.response.CourseResponse;
import org.springframework.data.domain.Page;

public interface CourseService {

    /**
     * Get One
     *
     * @param courseId
     * @return
     */
    CourseResponse getOne(Long courseId);

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    Page<CourseResponse> getAll(int size, int page);

    /**
     * Add
     *
     * @param courseRequest
     */
    void add(CourseRequest courseRequest);

    /**
     * Update
     *
     * @param courseId
     * @param courseResponse
     */
    void update(Long courseId, CourseRequest courseRequest);

    /**
     * Delete
     *
     * @param courseId
     */
    void delete(Long courseId);
}
