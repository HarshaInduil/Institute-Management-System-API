package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.TopicRequest;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.dto.response.TopicResponse;
import com.ims.sampleproject.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1/app/topic")
public class TopicController {

    private final Logger logger = LoggerFactory.getLogger(TopicController.class);

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TopicResponse> getOne(
            @PathVariable("id") Long topicId
    ) {
        logger.info("Get Topic With ID :: {}", topicId);
        return ResponseEntity.ok(topicService.getOne(topicId));
    }

    @GetMapping(value = "/")
    public ResponseEntity<Page<TopicResponse>> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get All Topics  Page :: {} Size::{}", page, size);
        return ResponseEntity.ok(topicService.getAll(size, page));
    }

    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> add(
            @RequestBody TopicRequest topicRequest
    ) {
        topicService.add(topicRequest);
        logger.info("Add New Topic Name :: {}", topicRequest.getName());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> add(
            @PathVariable("id") long topicId,
            @RequestBody TopicRequest topicRequest
    ) {
        topicService.update(topicId, topicRequest);
        logger.info("Update Topic ID :: {}", topicId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> delete(
            @PathVariable("id") Long topicId
    ) {
        logger.info("Delete Topic With ID :: {}", topicId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
