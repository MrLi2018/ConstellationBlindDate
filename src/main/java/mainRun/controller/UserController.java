package mainRun.controller;

import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/21
 * Time: 16:55
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "")
public class UserController {
    Logger logger = Logger.getLogger(getClass());
    @Resource
    private UserService userService;

    @GetMapping("/allinfo")
    public List<SpdUser> getAllUserInfo() {
        logger.info("*******************查找所有的用户信息**********************");
        return userService.findAllUserInfo();
    }


    /**
     * @param spdUser
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 14:40 2019/1/22
     * @Description: 根据用户id修改用户数据
     */
    @PutMapping("/update")
    public ResultBean updateUserInfoByUserId(@RequestBody SpdUser spdUser) {
        logger.info("**************************************用户信息更新开始*************************");
        return userService.updateUserInfoById(spdUser);
    }


    /**
     * @param id
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 17:41 2019/1/22
     * @Description: 根据用户id来删除用户信息
     */
    @DeleteMapping("/delete/{id}")
    public ResultBean deleteUserInfoByUserId(@PathVariable Integer id) {
        return userService.deleteUserInfoById(id);
    }
}
