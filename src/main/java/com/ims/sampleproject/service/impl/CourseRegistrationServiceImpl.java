package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.request.CourseRegistrationRequest;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Batch;
import com.ims.sampleproject.model.CourseRegistration;
import com.ims.sampleproject.model.Student;
import com.ims.sampleproject.repository.BatchRepository;
import com.ims.sampleproject.repository.CourseRegistrationRepository;
import com.ims.sampleproject.repository.StudentRepository;
import com.ims.sampleproject.service.CourseRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    private final Logger logger = LoggerFactory.getLogger(CourseRegistrationServiceImpl.class);

    private final BatchRepository batchRepository;

    private final StudentRepository studentRepository;

    private final CourseRegistrationRepository courseRegistrationRepository;

    public CourseRegistrationServiceImpl(BatchRepository batchRepository, StudentRepository studentRepository, CourseRegistrationRepository courseRegistrationRepository) {
        this.batchRepository = batchRepository;
        this.studentRepository = studentRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    /**
     * Register Student
     *
     * @param courseRegistrationRequest
     */
    @Override
    public void courseRegistration(CourseRegistrationRequest courseRegistrationRequest) {
        CourseRegistration courseRegistration = courseRegistrationRequest.getCourseRegistrationObject();
        Optional<Batch> batch = batchRepository.findById(courseRegistrationRequest.getBatchId());
        Optional<Student> student = studentRepository.findById(courseRegistrationRequest.getStudentId());

        if (batch.isPresent()) {
            courseRegistration.setBatch(batch.get());
        } else {
            logger.error("Cannot Find Batch with Id:: {}", courseRegistrationRequest.getBatchId());
            throw new ResourceNotFoundException("Cannot Find Batch with Id" + courseRegistrationRequest.getBatchId());
        }
        if (student.isPresent()) {
            courseRegistration.setStudent(student.get());
        } else {
            logger.error("Cannot Find Student with Id:: {}", courseRegistrationRequest.getStudentId());
            throw new ResourceNotFoundException("Cannot Find Student with Id" + courseRegistrationRequest.getStudentId());
        }

        courseRegistrationRepository.save(courseRegistration);
    }
}
