package com.zzx.dao;

import com.zzx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zzx
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 通过用户ID查找用户实体
     *
     * @param userId 用户ID
     * @return 用户实体
     */
    User findByUserId(Integer userId);
}
