package cn.com.qpm.usermanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qpm.usermanage.model.LoginUser;

public interface LoginUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
    
    LoginUser selectByLoginMess(@Param("email")String email, @Param("password")String password);
    
    List<LoginUser> selectall();
}