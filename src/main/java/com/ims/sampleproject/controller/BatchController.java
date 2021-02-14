package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.BatchRequest;
import com.ims.sampleproject.dto.response.BatchResponse;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/batch")
public class BatchController {

    private final Logger logger = LoggerFactory.getLogger(BatchController.class);

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    /**
     * Get one
     *
     * @param batchId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<BatchResponse> get(
            @PathVariable("id") Long batchId
    ) {
        logger.info("Get Batch With Id :: {}", batchId);
        return ResponseEntity.ok(batchService.getOne(batchId));
    }

    /**
     * Get All
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity<Page<BatchResponse>> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get Class Room List Page :: {}  Size :: {}", page, size);
        return ResponseEntity.ok(batchService.getAll(size, page));
    }

    /**
     * Add New One
     *
     * @param batchRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> add(
            @RequestBody BatchRequest batchRequest
    ) {
        batchService.add(batchRequest);
        logger.info("Add Batch Name :: {} Email :: {}", batchRequest.getName());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    /**
     * Update
     *
     * @param batchId
     * @param batchRequest
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> update(
            @PathVariable("id") Long batchId,
            @RequestBody BatchRequest batchRequest
    ) {
        batchService.update(batchId, batchRequest);
        logger.info("Updated Batch with Id :: {} ", batchId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    /**
     * Delete
     *
     * @param batchId
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> delete(
            @PathVariable("id") Long batchId
    ) {
        batchService.delete(batchId);
        logger.info("Delete batch with Id :: {} ", batchId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
