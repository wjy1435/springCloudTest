package com.example.demo.service;

import com.example.demo.dao.loginDao;
import com.example.demo.entity.AyUser;
import com.example.demo.error.BussinessException;
import com.example.demo.repository.AyUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class CommonServiceImpl implements  CommonService {


    @Autowired
    private loginDao logindao;

    @Autowired
    private AyUserRepository ayUserRepository;

    private static final Logger logger  =  LogManager.getLogger(CommonServiceImpl.class);


    @Override
    public List<AyUser> getAllUser() {

        return logindao.getAllUser();
    }

    @Override
    public AyUser login(String name, String password) {

        return logindao.login(name,password);
    }

    @Override
    public AyUser findByUserName(String name) {

        return logindao.findByUserName(name);

    }



    @Override
    public void insertData(String id ,String name, String password) {

         logindao.insertData(id ,name, password);
    }

    @Override
    public void deleteData(String id) {
        logindao.deleteData(id);
    }

    @Override
    public void updateData(String id ,String name, String password) {
         logindao.updateData(id ,name, password);
    }

    @Override
    public AyUser findById(String id){
        return ayUserRepository.getOne(id);
    }

    @Override
    public List<AyUser> findAll(){

        System.out.println("开始做任务");
        long start = System.currentTimeMillis();
        List<AyUser> ayUserList = ayUserRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("完成耗时"+(end - start)+"毫秒");
        return ayUserRepository.findAll();
    }


    @Override
    @Async
    public Future<List<AyUser>> findAsynAll(){
        try {
            System.out.println("开始做任务1");

            long start = System.currentTimeMillis();
            List<AyUser> ayUserList = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成耗时"+(end - start)+"毫秒");
        }catch (Exception e){
            logger.info("method{findAll} error");
            return new AsyncResult<List<AyUser>>(null);
        }
        return new AsyncResult<List<AyUser>>(null);
    }

    @Override
    public AyUser save(AyUser ayUser){
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id){
        ayUserRepository.deleteById(id);
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }


    @Override
    @Retryable(value= {BussinessException.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public AyUser findByNameAndPasswordRetry(String name, String password) {
        System.out.println("{findByNameAndPasswordRetry} 方法失败重试");
        throw  new BussinessException();
//        return  logindao.login(name,password);
    }
}
