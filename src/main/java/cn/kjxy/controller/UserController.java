package cn.kjxy.controller;

import cn.kjxy.entity.UserEntity;
import cn.kjxy.service.UserService;
import cn.kjxy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Integer id){
        userService.deleteUser(id);
        return new Result(200,"删除用户成功");
    }
    @PutMapping("/update")
    public Result update(@RequestBody UserEntity user){
        userService.updateUser(user);
        return new Result(200,"修改用户成功");
    }
    @GetMapping("/get")
    public Result getUsers(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<UserEntity> list = userService.getUsers(pageNum,pageSize);
        Integer totalCount = userService.getUserCount();
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;

        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return new Result(200,"用户查询成功",data);
    }
}
