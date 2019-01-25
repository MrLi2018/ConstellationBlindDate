package mainRun.service.impl;

import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.bean.result.ResultFactory;
import mainRun.dao.SpdUserMapper;
import mainRun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/21
 * Time: 16:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SpdUserMapper spdUserMapper;

    /**
     * @param
     * @return java.util.List<mainRun.bean.SpdUser>
     * @author 栗旭辰
     * @date 17:00 2019/1/21
     * @Description: 查找所有的用户信息
     */
    @Override
    public List<SpdUser> findAllUserInfo() {
        List<SpdUser> list = spdUserMapper.selectAllSpdUsers();
        return list;
    }


    /**
     * @param userBean
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 14:33 2019/1/22
     * @Description: 更新用户信息
     */
    @Override
    public ResultBean updateUserInfoById(SpdUser userBean) {
        ResultBean resultBean = null;
        int index = 0;
        //添加更新时间
        userBean.setXgsj(new Date());
        index = spdUserMapper.updateByPrimaryKeySelective(userBean);
        if (index > 0) {
            resultBean = ResultFactory.buildSuccessResult(userBean, "修改成功");
        } else {
            resultBean = ResultFactory.buildFailResult("更新失败，请检查信息填写无误后重试");
        }
        return resultBean;
    }


    /**
     * @param id
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 17:36 2019/1/22
     * @Description: 删除用户信息
     */
    @Override
    public ResultBean deleteUserInfoById(Integer id) {
        ResultBean rb = null;
        int index = 0;
        if (id != null) {
            index = spdUserMapper.deleteByPrimaryKey(id);
            if (index>0){
                //表示删除成功
                rb = ResultFactory.buildSuccessResult(id,"删除成功");
            }else {
                rb = ResultFactory.buildFailResult("删除失败");
            }
        } else {
            rb = ResultFactory.buildFailResult("删除失败");
        }


        return rb;
    }
}
