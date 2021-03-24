package com.ims.sampleproject.dto.request;

import com.ims.sampleproject.model.ClassRoom;
import lombok.Data;

@Data
public class ClassRoomRequest {
    private Long id;
    private String name;
    private int numberOfSeat;
    private String description;

    public ClassRoom getClassRoomEntity() {
        return new ClassRoom(
                this.name,
                this.numberOfSeat,
                this.description
        );
    }
}
