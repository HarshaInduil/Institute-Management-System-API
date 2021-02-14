package com.ims.sampleproject.service;

import com.ims.sampleproject.dto.request.TopicRequest;
import com.ims.sampleproject.dto.response.TopicResponse;
import org.springframework.data.domain.Page;

public interface TopicService {

    /**
     * Get one Topic By Id
     *
     * @param topicId
     * @return
     */
    TopicResponse getOne(Long topicId);

    /**
     * Get All Topics
     *
     * @param size
     * @param page
     * @return
     */
    Page<TopicResponse> getAll(int size, int page);

    /**
     * Add Topic
     *
     * @param topicRequest
     */
    void add(TopicRequest topicRequest);

    /**
     * Update Topic
     *
     * @param topicId
     * @param topicRequest
     */
    void update(Long topicId, TopicRequest topicRequest);

    /**
     * Delete Topic
     *
     * @param topicId
     */
    void delete(Long topicId);
}
