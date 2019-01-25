package mainRun;


import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.service.LoginService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/9
 * Time: 16:14
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     * 给VueLoginInfoVo对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
     * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     */
    @RequestMapping(value = "/logininfo", method = RequestMethod.GET)
    public ResultBean login(HttpServletRequest request, @ModelAttribute SpdUser loginInfoVo) {
        return loginService.voildLoginInfoBySpdUserInfo(request,loginInfoVo);
    }
}
