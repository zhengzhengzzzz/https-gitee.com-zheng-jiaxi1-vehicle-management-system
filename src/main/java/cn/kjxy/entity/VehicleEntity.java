package cn.kjxy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class VehicleEntity {
    private Integer id;
    private String model;
    private String brand;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date year;
    private Integer type;
    private Integer mileage;
    private String licensePlate;
    private Integer status;
    private Integer user_id;
    private UserEntity userEntity;
}
