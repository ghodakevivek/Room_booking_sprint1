package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.Demo;
@Repository
public interface DemoRepository extends JpaRepository<Demo, Integer>{

	Demo findByDemoUsernameAndDemoPassword(String demoUsername, String demoPassword);
}
