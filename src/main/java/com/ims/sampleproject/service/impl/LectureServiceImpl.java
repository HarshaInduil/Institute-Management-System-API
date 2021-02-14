package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.LectureRequest;
import com.ims.sampleproject.dto.response.LectureResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Lecture;
import com.ims.sampleproject.repository.LectureRepository;
import com.ims.sampleproject.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LectureServiceImpl implements LectureService {

    private static final String LOGTEXT = "Cannot find Lecture With ID";

    private final Logger logger = LoggerFactory.getLogger(LectureServiceImpl.class);

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    /**
     * Get One
     *
     * @param lectureId
     * @return
     */
    @Override
    public LectureResponse getOne(Long lectureId) {
        Optional<Lecture> lecture = lectureRepository.findById(lectureId);
        if (lecture.isPresent()) {
            return new LectureResponse(lecture.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, lectureId);
            throw new ResourceNotFoundException(LOGTEXT + lectureId);
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
    public Page<LectureResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return lectureRepository.findAll(pageable).map(LectureResponse::new);
    }

    /**
     * Add
     *
     * @param lectureRequest
     */
    @Override
    public void add(LectureRequest lectureRequest) {
        Lecture lecture = lectureRequest.getLectureObject();
        lecture.setStatus(Status.ACTIVE);
        lectureRepository.save(lecture);
    }

    /**
     * Update
     *
     * @param lectureId
     * @param lectureRequest
     */
    @Override
    public void update(Long lectureId, LectureRequest lectureRequest) {
        Optional<Lecture> lecture = lectureRepository.findById(lectureId);
        if (lecture.isPresent()) {
            lecture.get().setName(lectureRequest.getName());
            lecture.get().setAddress(lectureRequest.getAddress());
            lecture.get().setContactNumber(lectureRequest.getContactNumber());
            lecture.get().setEmail(lectureRequest.getEmail());
            lecture.get().setJoinedDate(lectureRequest.getJoinedDate());
            lecture.get().setExperience(lectureRequest.getExperience());
            lecture.get().setSalary(lectureRequest.getSalary());
            lecture.get().setLectureCode(lectureRequest.getLectureCode());

            lectureRepository.save(lecture.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, lectureId);
            throw new ResourceNotFoundException(LOGTEXT + lectureId);
        }
    }

    /**
     * Delete
     *
     * @param lectureId
     */
    @Override
    public void delete(Long lectureId) {
        Optional<Lecture> lecture = lectureRepository.findById(lectureId);
        if (lecture.isPresent()) {
            lectureRepository.deleteById(lectureId);
        } else {
            logger.error("{} :: {}", LOGTEXT, lectureId);
            throw new ResourceNotFoundException(LOGTEXT + lectureId);
        }
    }
}
