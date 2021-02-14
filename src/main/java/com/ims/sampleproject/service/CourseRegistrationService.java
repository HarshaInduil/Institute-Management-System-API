package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.CourseRegistrationRequest;

public interface CourseRegistrationService {

    /**
     * Register Course
     *
     * @param courseRegistrationRequest
     */
    void courseRegistration(CourseRegistrationRequest courseRegistrationRequest);
}
