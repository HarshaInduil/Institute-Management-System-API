package com.ims.sampleproject.controller;

import com.ims.sampleproject.dto.request.CourseRegistrationRequest;
import com.ims.sampleproject.dto.response.MessageResponse;
import com.ims.sampleproject.service.CourseRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/course-registration")
public class CourseRegistrationController {

    private final Logger logger = LoggerFactory.getLogger(CourseRegistrationController.class);

    private final CourseRegistrationService courseRegistrationService;

    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;
    }

    /**
     * Register Student For Batch
     *
     * @param courseRegistrationRequest
     * @return
     */
    @PostMapping(value = "/")
    public ResponseEntity<MessageResponse> add(
            @RequestBody CourseRegistrationRequest courseRegistrationRequest
    ) {
        courseRegistrationService.courseRegistration(courseRegistrationRequest);
        logger.info("Add Student for Batch  studentId :: {} batchId :: {}", courseRegistrationRequest.getStudentId(), courseRegistrationRequest.getBatchId());
        return ResponseEntity.ok(new MessageResponse("Successfully Registered !"));
    }
}
