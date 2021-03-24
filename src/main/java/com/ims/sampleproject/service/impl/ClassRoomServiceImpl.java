package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.ClassRoomRequest;
import com.ims.sampleproject.dto.response.ClassRoomResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.ClassRoom;
import com.ims.sampleproject.repository.ClassRoomRepository;
import com.ims.sampleproject.service.ClassRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private static final String LOGTEXT = "Cannot find ClassRoom With ID";

    private final Logger logger = LoggerFactory.getLogger(ClassRoomServiceImpl.class);

    private final ClassRoomRepository classRoomRepository;

    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    /**
     * Get one
     *
     * @param classRoomId
     * @return
     */
    @Override
    public ClassRoomResponse getOne(Long classRoomId) {
        Optional<ClassRoom> classRoom = classRoomRepository.findById(classRoomId);
        if (classRoom.isPresent()) {
            return new ClassRoomResponse(classRoom.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, classRoomId);
            throw new ResourceNotFoundException(LOGTEXT + classRoomId);
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
    public Page<ClassRoomResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return classRoomRepository.findAll(pageable).map(ClassRoomResponse::new);
    }

    /**
     * Add
     *
     * @param classRoomRequest
     */
    @Override
    public void add(ClassRoomRequest classRoomRequest) {
        ClassRoom classRoom = classRoomRequest.getClassRoomEntity();
        classRoom.setStatus(Status.ACTIVE);
        classRoomRepository.save(classRoom);
    }

    /**
     * Update
     *
     * @param classRoomId
     * @param classRoomRequest
     */
    @Override
    public void update(Long classRoomId, ClassRoomRequest classRoomRequest) {
        Optional<ClassRoom> classRoom = classRoomRepository.findById(classRoomId);
        if (classRoom.isPresent()) {
            classRoom.get().setName(classRoomRequest.getName());
            classRoom.get().setNumberOfSeat(classRoomRequest.getNumberOfSeat());
            classRoom.get().setDescription(classRoomRequest.getDescription());

            classRoomRepository.save(classRoom.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, classRoomId);
            throw new ResourceNotFoundException(LOGTEXT + classRoomId);
        }
    }

    /**
     * Delete
     *
     * @param classRoomId
     */
    @Override
    public void delete(Long classRoomId) {
        Optional<ClassRoom> classRoom = classRoomRepository.findById(classRoomId);
        if (classRoom.isPresent()) {
            classRoomRepository.deleteById(classRoomId);
        } else {
            logger.error("{} :: {}", LOGTEXT, classRoomId);
            throw new ResourceNotFoundException(LOGTEXT + classRoomId);
        }
    }
}
