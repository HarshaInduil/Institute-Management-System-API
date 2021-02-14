package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.LectureRequest;
import com.ims.sampleproject.dto.response.LectureResponse;
import org.springframework.data.domain.Page;

public interface LectureService {

    /**
     * Get One
     *
     * @param lectureId
     * @return
     */
    LectureResponse getOne(Long lectureId);

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    Page<LectureResponse> getAll(int size, int page);

    /**
     * Add
     *
     * @param lectureRequest
     */
    void add(LectureRequest lectureRequest);

    /**
     * Update
     *
     * @param lectureId
     * @param lectureRequest
     */
    void update(Long lectureId, LectureRequest lectureRequest);

    /**
     * Delete
     *
     * @param lectureId
     */
    void delete(Long lectureId);
}
