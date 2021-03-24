package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.CourseRequest;
import com.ims.sampleproject.dto.response.CourseResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Course;
import com.ims.sampleproject.repository.CourseRepository;
import com.ims.sampleproject.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private static final String LOGTEXT = "Cannot find Course With ID";

    private final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Get One
     *
     * @param courseId
     * @return
     */
    @Override
    public CourseResponse getOne(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return new CourseResponse(course.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, courseId);
            throw new ResourceNotFoundException(LOGTEXT + courseId);
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
    public Page<CourseResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findAll(pageable).map(CourseResponse::new);
    }

    /**
     * Add
     *
     * @param courseRequest
     */
    @Override
    public void add(CourseRequest courseRequest) {
        Course course = courseRequest.getCourseEntity();
        course.setStatus(Status.ACTIVE);
        courseRepository.save(course);
    }

    /**
     * Update
     *
     * @param courseId
     * @param courseRequest
     */
    @Override
    public void update(Long courseId, CourseRequest courseRequest) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            course.get().setName(courseRequest.getName());
            course.get().setCourseFee(courseRequest.getCourseFee());
            course.get().setDescription(courseRequest.getDescription());
            course.get().setDuration(courseRequest.getDuration());

            courseRepository.save(course.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, courseId);
            throw new ResourceNotFoundException(LOGTEXT + courseId);
        }
    }

    /**
     * Delete
     *
     * @param courseId
     */
    @Override
    public void delete(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            courseRepository.deleteById(courseId);
        } else {
            logger.error("{} :: {}", LOGTEXT, courseId);
            throw new ResourceNotFoundException(LOGTEXT + courseId);
        }
    }
}
