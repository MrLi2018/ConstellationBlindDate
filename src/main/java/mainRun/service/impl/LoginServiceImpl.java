package mainRun.service.impl;

import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.bean.result.ResultFactory;
import mainRun.dao.SpdUserMapper;
import mainRun.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/17
 * Time: 9:33
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private SpdUserMapper spdUserMapper;

    /**
     * @param spdUser
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 9:37 2019/1/17
     * @Description: 验证用户的登录信息
     */
    @Override
    public ResultBean voildLoginInfoBySpdUserInfo(HttpServletRequest request,SpdUser spdUser) {
        ResultBean rb = null;
        String username = spdUser.getUsername();
        SpdUser su = null;
        su = spdUserMapper.selectByUserName(username);
        if (su != null) { //表示用户名已被注册，可以开始登录验证
            if (spdUser.getPassword().equals(su.getPassword())) {
                rb = ResultFactory.buildSuccessResult(su, "登陆成功");
                //保存当前的用户登录信息
                request.getSession().setAttribute("loginuser",su);
            } else {
                rb = ResultFactory.buildFailResult("密码错误，请重新登录");
            }
        } else {
            rb = ResultFactory.buildFailResult("用户名不存在");
        }
        return rb;
    }
}
