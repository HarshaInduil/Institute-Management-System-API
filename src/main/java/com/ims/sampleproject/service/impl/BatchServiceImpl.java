package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.BatchRequest;
import com.ims.sampleproject.dto.response.BatchResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Batch;
import com.ims.sampleproject.repository.BatchRepository;
import com.ims.sampleproject.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    private static final String LOGTEXT = "Cannot find Batch With ID";

    private final Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

    private final BatchRepository batchRepository;

    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    /**
     * Get one
     *
     * @param batchId
     * @return
     */
    @Override
    public BatchResponse getOne(Long batchId) {
        Optional<Batch> batch = batchRepository.findById(batchId);
        if (batch.isPresent()) {
            return new BatchResponse(batch.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, batchId);
            throw new ResourceNotFoundException(LOGTEXT + batchId);
        }
    }

    /**
     * Get All
     *
     * @param size
     * @param page
     * @return
     */
    @Override
    public Page<BatchResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return batchRepository.findAll(pageable).map(BatchResponse::new);
    }

    /**
     * Add
     *
     * @param batchRequest
     */
    @Override
    public void add(BatchRequest batchRequest) {
        Batch batch = batchRequest.getBatchObject();
        batch.setStatus(Status.ACTIVE);
        batchRepository.save(batch);
    }

    /**
     * Update
     *
     * @param batchId
     * @param batchRequest
     */
    @Override
    public void update(Long batchId, BatchRequest batchRequest) {
        Optional<Batch> batch = batchRepository.findById(batchId);
        if (batch.isPresent()) {
            batch.get().setName(batchRequest.getName());
            batch.get().setMaximumStudentCount(batchRequest.getMaximumStudentCount());
            batch.get().setStartDate(batchRequest.getStartDate());
            batch.get().setDescription(batchRequest.getDescription());

            batchRepository.save(batch.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, batchId);
            throw new ResourceNotFoundException(LOGTEXT + batchId);
        }
    }

    /**
     * Delete
     *
     * @param batchId
     */
    @Override
    public void delete(Long batchId) {
        Optional<Batch> batch = batchRepository.findById(batchId);
        if (batch.isPresent()) {
            batchRepository.deleteById(batchId);
        } else {
            logger.error("{} :: {}", LOGTEXT, batchId);
            throw new ResourceNotFoundException(LOGTEXT + batchId);
        }
    }
}
