package mainRun.service;

import mainRun.bean.SpdUser;
import mainRun.bean.UserBean;
import mainRun.bean.result.ResultBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/21
 * Time: 16:58
 */
public interface UserService {

    List<SpdUser> findAllUserInfo();

    ResultBean updateUserInfoById(SpdUser userBean);

    ResultBean deleteUserInfoById(Integer id);
}
