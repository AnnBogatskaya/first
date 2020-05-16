package org.bogatskaya.schedule.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordDTO {

    private String date;

    private String time;

    private String complaint;

    private String fullname;

}
