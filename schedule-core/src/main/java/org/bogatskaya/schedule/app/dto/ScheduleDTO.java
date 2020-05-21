package org.bogatskaya.schedule.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDTO {

    private String date;

    private String timeFrom;

    private String timeTo;

    private String complaint;

    private boolean isAvailable;


}
