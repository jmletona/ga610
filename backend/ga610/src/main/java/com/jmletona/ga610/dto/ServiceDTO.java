package com.jmletona.ga610.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ServiceDTO {

    private Integer serviceId;
    private String serviceName;
   //private LocalDate createdAt;
}
