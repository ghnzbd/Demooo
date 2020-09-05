package com.example.jsondemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author CBeann
 * @create 2020-09-05 19:27
 */
@Data
public class Student {

    private String name;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private LocalTime localTime;
}
