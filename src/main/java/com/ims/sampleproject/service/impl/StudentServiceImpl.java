package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.StudentRequest;
import com.ims.sampleproject.dto.response.StudentResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Student;
import com.ims.sampleproject.repository.StudentRepository;
import com.ims.sampleproject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Get Student By Id
     *
     * @param studentId
     * @return
     */
    @Override
    public StudentResponse getOne(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            return new StudentResponse(studentOptional.get());
        } else {
            logger.error("Cannot Find Student With ID: {}", studentId);
            throw new ResourceNotFoundException("Cannot Find Student With ID:" + studentId);
        }
    }

    /**
     * Get All Students
     *
     * @param size
     * @param page
     * @return
     */
    @Override
    public Page<StudentResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pagedStudentList = studentRepository.findAll(pageable);
        return pagedStudentList.map(StudentResponse::new);
    }

    /**
     * Add Student
     *
     * @param studentRequest
     */
    @Override
    public void add(StudentRequest studentRequest) {
        Student student = studentRequest.getStudentEntity();
        student.setStatus(Status.ACTIVE);
        studentRepository.save(student);
    }

    /**
     * Update Student
     *
     * @param studentId
     * @param studentRequest
     */
    @Override
    public void update(Long studentId, StudentRequest studentRequest) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            student.get().setFullName(studentRequest.getFullName());
            student.get().setAddress(studentRequest.getAddress());
            student.get().setAge(studentRequest.getAge());
            student.get().setDateOfBirth(studentRequest.getDateOfBirth());
            student.get().setJoinedDate(studentRequest.getJoinedDate());
            student.get().setContactNumber(studentRequest.getContactNumber());
            student.get().setEmail(studentRequest.getEmail());

            studentRepository.save(student.get());
        } else {
            logger.error("Cannot Update Student With ID: {}", studentId);
            throw new ResourceNotFoundException("Cannot Update Student With ID:" + studentId);
        }
    }

    /**
     * Delete Student
     *
     * @param studentId
     */
    @Override
    public void delete(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            studentRepository.deleteById(studentId);
        } else {
            logger.error("Cannot Delete Student With ID: {}", studentId);
            throw new ResourceNotFoundException("Cannot Delete Student With ID:" + studentId);
        }
    }
}
