package com.example.demo.service;

import com.example.demo.entity.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Future;

//@Transactional

public interface CommonService {

    AyUser login(String name , String password);

    void insertData(String id ,String name,String password);

    void updateData(String id ,String name,String password);

    void deleteData(String id);

    List<AyUser> getAllUser();



    //============================================================


    AyUser findById(String id);

    AyUser findByUserName(String name);


    List<AyUser> findAll();

    AyUser save(AyUser ayUser);

    void delete(String id);

    Page<AyUser> findAll(Pageable pageable);

    Future<List<AyUser>>  findAsynAll();


    AyUser findByNameAndPasswordRetry(String name,String password);

}
