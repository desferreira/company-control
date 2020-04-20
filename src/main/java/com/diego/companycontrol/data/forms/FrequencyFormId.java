package com.diego.companycontrol.data.forms;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class FrequencyFormId {

    public Long id;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    public LocalDateTime startHour;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    public LocalDateTime finalHour;

}
