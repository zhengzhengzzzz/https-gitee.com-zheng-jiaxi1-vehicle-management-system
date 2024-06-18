package cn.kjxy.service.impl;

import cn.kjxy.entity.VehicleEntity;
import cn.kjxy.mapper.VehicleMapper;
import cn.kjxy.service.VehicleService;
import cn.kjxy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;
    @Override
    public Result addVehicle(VehicleEntity vehicleEntity){
         if(vehicleEntity.getUser_id()==null){
             return new Result(404,"传入用户ID不能为空");
         }
         vehicleMapper.addVehicle(vehicleEntity);
         return new Result(200,"车辆添加成功");
    }
    @Override
    public Result deleteVehicle(Integer id){
        if(id == null){
            return new Result(404,"请传入要删除车辆的ID");
        }
        if(vehicleMapper.getVehicleById(id) == null){
            return new Result(404,"请传入正确的车辆ID");
        }
            vehicleMapper.deleteVehicle(id);
        return new Result(200,"车辆删除成功");
    }
    @Override
    public Result updateVehicle(VehicleEntity vehicleEntity){
        if(vehicleEntity.getId() == null){
            return new Result(404,"传入车辆ID不能为空");
        }
        if(vehicleMapper.getVehicleById(vehicleEntity.getId()) == null){
            return new Result(404,"请传入正确的车辆ID");
        }
        if(vehicleEntity.getUser_id()==null){
            return new Result(404,"传入用户ID不能为空");
        }
         vehicleMapper.updateVehicle(vehicleEntity);
        return new Result(200,"车辆修改成功");
    }
    @Override
    public Result getVehicleList(Integer pageNow,Integer pageSize){
        if(pageNow == 1){
            pageNow = 0;
        }
        List<VehicleEntity> list = vehicleMapper.getVehicleList(pageNow,pageSize);
        Integer totalCount = vehicleMapper.getVehicleCount();
        Integer totalPages = (totalCount + pageSize-1) / pageSize;
        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNow);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return new Result(200,"查询成功",data);
    }
    @Override
    public Integer getVehicleCount(){
        return vehicleMapper.getVehicleCount();
    }
}
