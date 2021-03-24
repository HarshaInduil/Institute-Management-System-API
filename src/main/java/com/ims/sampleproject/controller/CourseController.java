package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.CourseRequest;
import com.ims.sampleproject.dto.response.CourseResponse;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Get one
     *
     * @param courseId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseResponse> get(
            @PathVariable("id") Long courseId
    ) {
        logger.info("Get Course With Id :: {}", courseId);
        return ResponseEntity.ok(courseService.getOne(courseId));
    }

    /**
     * Get All
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity<Page<CourseResponse>> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get Course List Page :: {}  Size :: {}", page, size);
        return ResponseEntity.ok(courseService.getAll(size, page));
    }

    /**
     * Add New One
     *
     * @param courseRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> add(
            @RequestBody CourseRequest courseRequest
    ) {
        courseService.add(courseRequest);
        logger.info("Add New Course Name :: {} Email :: {}", courseRequest.getName());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    /**
     * Update
     *
     * @param courseId
     * @param courseRequest
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> update(
            @PathVariable("id") Long courseId,
            @RequestBody CourseRequest courseRequest
    ) {
        courseService.update(courseId, courseRequest);
        logger.info("Updated Course with Id :: {} ", courseId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    /**
     * Delete
     *
     * @param courseId
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> delete(
            @PathVariable("id") Long courseId
    ) {
        courseService.delete(courseId);
        logger.info("Delete Course with Id :: {} ", courseId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
