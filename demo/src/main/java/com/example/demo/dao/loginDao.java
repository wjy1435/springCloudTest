package com.example.demo.dao;


import com.example.demo.entity.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface loginDao{
    AyUser login(@Param("name") String name , @Param("password") String password);

    void insertData(@Param("id") String id,@Param("name") String name, @Param("password") String password);

    void updateData(@Param("id") String id,@Param("name") String name, @Param("password") String password);

    void deleteData(@Param("id") String id);

    AyUser findByUserName(@Param("name") String name);

    List<AyUser> getAllUser();
}
