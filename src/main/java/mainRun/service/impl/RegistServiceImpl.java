package mainRun.service.impl;

import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.bean.result.ResultFactory;
import mainRun.dao.SpdUserMapper;
import mainRun.service.RegistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/15
 * Time: 15:07
 */
@Service
public class RegistServiceImpl implements RegistService {

    @Resource
    private SpdUserMapper spdUserMapper;

    /**
     * @param userBean
     * @return java.lang.String
     * @author 栗旭辰
     * @date 15:08 2019/1/15
     * @Description: 保存用户的注册信息
     */
    @Override
    public ResultBean saveRegistResult(SpdUser userBean) {
        ResultBean rb = null;
        Boolean flag = true;
        SpdUser spdUser = null;
        int index = 0;
        //查找系统中用户名是否已经存在
        String username = userBean.getUsername();
        if (null != username && !"".equals(username)) {
            spdUser = spdUserMapper.selectByUserName(username);
            if (spdUser != null) {
                flag = false;
            }
        }
        if (flag) {
            //表示用户名目前不存在 。可以尽心注册
            userBean.setCjsj(new Date());
            index = spdUserMapper.insertSelective(userBean);
            if (index > 0) {
                rb = ResultFactory.buildSuccessResult(userBean, "注册成功");
            }
        } else {
            rb = ResultFactory.buildFailResult("注册失败，用户名已存在");
        }
        return rb;
    }


    /**
     * @param username
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 17:30 2019/1/16
     * @Description: 根据输入的用户名验证所注册的用户是否已经存在
     */
    @Override
    public ResultBean validRegistInfo(String username) {
        boolean flag = false; //标志是否已经存在
        String usernameTemp = username;
        SpdUser spdUser;
        ResultBean resultBean = null;
        if (null != usernameTemp && !"".equals(usernameTemp)) {
            spdUser = spdUserMapper.selectByUserName(usernameTemp);
            if (spdUser != null) {
                flag = true;
            }
        }
        if (flag) {
            resultBean = ResultFactory.buildFailResult("注册失败，该用户名已经被注册");
        }
        return resultBean;
    }
}
