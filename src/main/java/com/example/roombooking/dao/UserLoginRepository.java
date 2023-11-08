package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.UserLogin;
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{

	UserLogin findByUserLoginId(int userLoginId);
}
