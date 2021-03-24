package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.ClassRoomRequest;
import com.ims.sampleproject.dto.response.ClassRoomResponse;
import org.springframework.data.domain.Page;

public interface ClassRoomService {

    /**
     * Get One
     *
     * @param classRoomId
     * @return
     */
    ClassRoomResponse getOne(Long classRoomId);

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    Page<ClassRoomResponse> getAll(int size, int page);

    /**
     * Add
     *
     * @param classRoomRequest
     */
    void add(ClassRoomRequest classRoomRequest);

    /**
     * Update
     *
     * @param classRoomId
     * @param classRoomRequest
     */
    void update(Long classRoomId, ClassRoomRequest classRoomRequest);

    /**
     * Delete
     *
     * @param classRoomId
     */
    void delete(Long classRoomId);
}
