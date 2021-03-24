package com.ims.sampleproject.service.impl;

import com.ims.sampleproject.dto.enumtype.Status;
import com.ims.sampleproject.dto.request.TopicRequest;
import com.ims.sampleproject.dto.response.TopicResponse;
import com.ims.sampleproject.exception.ResourceNotFoundException;
import com.ims.sampleproject.model.Topic;
import com.ims.sampleproject.repository.TopicRepository;
import com.ims.sampleproject.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private static final String LOGTEXT = "Cannot find Topic With ID";

    private final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    /**
     * Get Topic
     *
     * @param topicId
     * @return
     */
    @Override
    public TopicResponse getOne(Long topicId) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if (topic.isPresent()) {
            return new TopicResponse(topic.get());
        } else {
            logger.error("{} ::{}", LOGTEXT, topicId);
            throw new ResourceNotFoundException(LOGTEXT + topicId);
        }
    }

    /**
     * Get All Topics
     *
     * @param size
     * @param page
     * @return
     */
    @Override
    public Page<TopicResponse> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return topicRepository.findAll(pageable).map(TopicResponse::new);
    }

    /**
     * Add Topic
     *
     * @param topicRequest
     */
    @Override
    public void add(TopicRequest topicRequest) {
        Topic topic = topicRequest.getTopicEntity();
        topic.setStatus(Status.ACTIVE);
        topicRepository.save(topic);
    }

    /**
     * Update Topic
     *
     * @param topicId
     * @param topicRequest
     */
    @Override
    public void update(Long topicId, TopicRequest topicRequest) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if (topic.isPresent()) {
            topic.get().setName(topicRequest.getName());
            topic.get().setLearningHours(topicRequest.getLearningHours());
            topic.get().setGpaValue(topicRequest.getGpaValue());
            topic.get().setDescription(topicRequest.getDescription());

            topicRepository.save(topic.get());
        } else {
            logger.error("{}:: {}", LOGTEXT, topicId);
            throw new ResourceNotFoundException(LOGTEXT + topicId);
        }
    }

    /**
     * Delete Topic
     *
     * @param topicId
     */
    @Override
    public void delete(Long topicId) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if (topic.isPresent()) {
            topicRepository.deleteById(topicId);
        } else {
            logger.error("{} :: {}", LOGTEXT, topicId);
            throw new ResourceNotFoundException(LOGTEXT + topicId);
        }
    }
}
