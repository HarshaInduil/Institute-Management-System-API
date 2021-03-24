package com.ims.sampleproject.dto.response;

import com.ims.sampleproject.model.ClassRoom;
import lombok.Data;

@Data
public class ClassRoomResponse {
    private Long id;
    private String name;
    private int numberOfSeat;
    private String description;

    public ClassRoomResponse(ClassRoom classRoom) {
        this.id = classRoom.getId();
        this.name = classRoom.getName();
        this.numberOfSeat = classRoom.getNumberOfSeat();
        this.description = classRoom.getDescription();
    }
}
