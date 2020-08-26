package cn.bjfu.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Ecodata {
    private Long datanumId;
    private Integer stationId;
    private Integer deviceId;
    private Integer datatypeId;
    private Date dataTime;
    private Double dataValue;
    private Integer exceptionFlag;
}
