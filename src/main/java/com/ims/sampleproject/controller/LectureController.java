package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.LectureRequest;
import com.ims.sampleproject.dto.response.LectureResponse;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/lecture")
public class LectureController {

    private final Logger logger = LoggerFactory.getLogger(LectureController.class);

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    /**
     * Get a Lecture
     *
     * @param lectureId
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<LectureResponse> getLecture(
            @PathVariable("id") Long lectureId
    ) {
        logger.info("Get Lecture With Id :: {}", lectureId);
        return ResponseEntity.ok(lectureService.getOne(lectureId));
    }

    /**
     * Get All Lectures
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/")
    public ResponseEntity<Page<LectureResponse>> getAllLectures(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        logger.info("Get Lecture List Page :: {}  Size :: {}", page, size);
        return ResponseEntity.ok(lectureService.getAll(size, page));
    }

    /**
     * Add New Lecture
     *
     * @param lectureRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> addLecture(
            @RequestBody LectureRequest lectureRequest
    ) {
        lectureService.add(lectureRequest);
        logger.info("Add New Lecture Name :: {} Email :: {}", lectureRequest.getName(), lectureRequest.getEmail());
        return ResponseEntity.ok(new MessageResponse("Successfully Added !"));
    }

    /**
     * Update a Lecture
     *
     * @param lectureId
     * @param lectureRequest
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> updateLecture(
            @PathVariable("id") Long lectureId,
            @RequestBody LectureRequest lectureRequest
    ) {
        lectureService.update(lectureId, lectureRequest);
        logger.info("Updated Lecture with Id :: {} ", lectureId);
        return ResponseEntity.ok(new MessageResponse("Successfully Updated !"));
    }

    /**
     * Delete a Lecture
     *
     * @param lectureId
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MessageResponse> deleteLecture(
            @PathVariable("id") Long lectureId
    ) {
        lectureService.delete(lectureId);
        logger.info("Delete Lecture with Id :: {} ", lectureId);
        return ResponseEntity.ok(new MessageResponse("Successfully Deleted !"));
    }
}
