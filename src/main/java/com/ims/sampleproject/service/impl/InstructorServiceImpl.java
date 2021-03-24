package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.InstructorRequest;
import com.ims.sampleproject.dto.response.InstructorResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Instructor;
import com.ims.sampleproject.repository.InstructorRepository;
import com.ims.sampleproject.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private static final String LOGTEXT = "Cannot find Instructor With ID";

    private final Logger logger = LoggerFactory.getLogger(InstructorServiceImpl.class);

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    /**
     * Get one
     *
     * @param instructorId
     * @return
     */
    @Override
    public InstructorResponse getOne(Long instructorId) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if (instructor.isPresent()) {
            return new InstructorResponse(instructor.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, instructorId);
            throw new ResourceNotFoundException(LOGTEXT + instructorId);
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
    public Page<InstructorResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return instructorRepository.findAll(pageable).map(InstructorResponse::new);
    }

    /**
     * Add
     *
     * @param instructorRequest
     */
    @Override
    public void add(InstructorRequest instructorRequest) {
        Instructor instructor = instructorRequest.getInstructorObject();
        instructor.setStatus(Status.ACTIVE);
        instructorRepository.save(instructor);
    }

    /**
     * Update
     *
     * @param instructorId
     * @param instructorRequest
     */
    @Override
    public void update(Long instructorId, InstructorRequest instructorRequest) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if (instructor.isPresent()) {
            instructor.get().setName(instructorRequest.getName());
            instructor.get().setAddress(instructorRequest.getAddress());
            instructor.get().setContactNumber(instructorRequest.getContactNumber());
            instructor.get().setEmail(instructorRequest.getEmail());
            instructor.get().setJoinedDate(instructorRequest.getJoinedDate());
            instructor.get().setExperience(instructorRequest.getExperience());
            instructor.get().setSalary(instructorRequest.getSalary());
            instructor.get().setInsturctorCode(instructorRequest.getInstructorCode());

            instructorRepository.save(instructor.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, instructorId);
            throw new ResourceNotFoundException(LOGTEXT + instructorId);
        }
    }

    /**
     * Delete
     *
     * @param instructorId
     */
    @Override
    public void delete(Long instructorId) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        if (instructor.isPresent()) {
            instructorRepository.deleteById(instructorId);
        } else {
            logger.error("{} :: {}", LOGTEXT, instructorId);
            throw new ResourceNotFoundException(LOGTEXT + instructorId);
        }
    }
}
