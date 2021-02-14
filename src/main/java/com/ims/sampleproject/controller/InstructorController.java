package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.InstructorRequest;
import com.ims.sampleproject.dto.response.InstructorResponse;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final Logger logger = LoggerFactory.getLogger(InstructorController.class);

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    /**
     * Get an instructor
     *
     * @param instructorId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<InstructorResponse> getInstructor(
            @PathVariable("id") Long instructorId
    ) {
        logger.info("Get Instructor With Id :: {}", instructorId);
        return ResponseEntity.ok(instructorService.getOne(instructorId));
    }

    /**
     * Get All Instructors
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity<Page<InstructorResponse>> getAllInstructor(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get Instructor List Page :: {}  Size :: {}", page, size);
        return ResponseEntity.ok(instructorService.getAll(size, page));
    }

    /**
     * Add New Instructor
     *
     * @param instructorRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> addInstructor(
            @RequestBody InstructorRequest instructorRequest
    ) {
        instructorService.add(instructorRequest);
        logger.info("Add New Instructor Name :: {} Email :: {}", instructorRequest.getName(), instructorRequest.getEmail());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    /**
     * Update a Lecture
     *
     * @param instructorId
     * @param instructorRequest
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> updateInstructor(
            @PathVariable("id") Long instructorId,
            @RequestBody InstructorRequest instructorRequest
    ) {
        instructorService.update(instructorId, instructorRequest);
        logger.info("Updated Instructor with Id :: {} ", instructorId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    /**
     * Delete a Lecture
     *
     * @param instructorId
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> deleteInstructor(
            @PathVariable("id") Long instructorId
    ) {
        instructorService.delete(instructorId);
        logger.info("Delete Instructor with Id :: {} ", instructorId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
