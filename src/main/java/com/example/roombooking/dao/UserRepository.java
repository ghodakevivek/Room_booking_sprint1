package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId(int userId);
}
