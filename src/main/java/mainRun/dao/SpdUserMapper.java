package mainRun.dao;


import mainRun.bean.SpdUser;

import java.util.List;

public interface SpdUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spd_user
     *
     * @mbg.generated Mon Jan 14 17:33:01 CST 2019
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spd_user
     *
     * @mbg.generated Mon Jan 14 17:33:01 CST 2019
     */
    int insertSelective(SpdUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spd_user
     *
     * @mbg.generated Mon Jan 14 17:33:01 CST 2019
     */
    SpdUser selectByPrimaryKey(Integer id);

    /**
     * 根据用户姓名查询用户信息
     *
     * @param username
     * @return
     */
     SpdUser selectByUserName(String username);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spd_user
     *
     * @mbg.generated Mon Jan 14 17:33:01 CST 2019
     */
    int updateByPrimaryKeySelective(SpdUser record);

    List<SpdUser> selectAllSpdUsers();

}