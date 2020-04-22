package com.example.demo.repository;

import com.example.demo.entity.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface AyUserRepository extends JpaRepository<AyUser,String> {

}
