package mainRun.service;

import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/17
 * Time: 9:33
 */
public interface LoginService {
    /**
     * @param  spdUser
     * @return
     * @author 栗旭辰
     * @date 9:36 2019/1/17
     * @Description: 验证用户的登录信息
     */
    ResultBean voildLoginInfoBySpdUserInfo(HttpServletRequest request, SpdUser spdUser);
}
