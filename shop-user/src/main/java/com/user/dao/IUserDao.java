package com.user.dao;

import com.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:36 下午
 */
public interface IUserDao extends JpaRepository<User,Integer> {
}
