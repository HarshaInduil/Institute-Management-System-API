package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.InstructorRequest;
import com.ims.sampleproject.dto.response.InstructorResponse;
import org.springframework.data.domain.Page;

public interface InstructorService {

    /**
     * Get One
     *
     * @param instructorId
     * @return
     */
    InstructorResponse getOne(Long instructorId);

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    Page<InstructorResponse> getAll(int size, int page);

    /**
     * Add
     *
     * @param instructorRequest
     */
    void add(InstructorRequest instructorRequest);

    /**
     * Update
     *
     * @param instructorId
     * @param instructorRequest
     */
    void update(Long instructorId, InstructorRequest instructorRequest);

    /**
     * Delete
     *
     * @param instructorId
     */
    void delete(Long instructorId);
}
