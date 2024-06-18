package cn.kjxy.service;

import cn.kjxy.entity.VehicleEntity;
import cn.kjxy.utils.Result;

import java.util.List;

public interface VehicleService {
    Result addVehicle(VehicleEntity vehicleEntity);
    Result deleteVehicle(Integer id);
    Result updateVehicle(VehicleEntity vehicleEntity);
    Result getVehicleList(Integer pageNow, Integer pageSize);
    Integer getVehicleCount();
}
