package com.jing.repository;

import com.jing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
//<User,Integer>第二个是可序列化的主键类型
}
