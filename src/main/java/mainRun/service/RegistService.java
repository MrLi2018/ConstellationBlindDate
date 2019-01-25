package mainRun.service;


import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/15
 * Time: 15:05
 */
public interface RegistService {

    /**
     * 保存用户的注册信息
     *
     * @param userBean
     * @return
     */
    ResultBean saveRegistResult(SpdUser userBean);

    ResultBean validRegistInfo(String username);
}
