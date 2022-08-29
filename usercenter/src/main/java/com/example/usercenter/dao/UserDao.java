package com.example.usercenter.dao;


import com.common.domain.UserCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserCenter,Integer> {
}
