package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.BatchRequest;
import com.ims.sampleproject.dto.response.BatchResponse;
import org.springframework.data.domain.Page;

public interface BatchService {

    /**
     * Get One
     *
     * @param batchId
     * @return
     */
    BatchResponse getOne(Long batchId);

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    Page<BatchResponse> getAll(int size, int page);

    /**
     * Add
     *
     * @param batchRequest
     */
    void add(BatchRequest batchRequest);

    /**
     * Update
     *
     * @param batchId
     * @param batchRequest
     */
    void update(Long batchId, BatchRequest batchRequest);

    /**
     * Delete
     *
     * @param batchId
     */
    void delete(Long batchId);
}
