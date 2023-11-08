package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.Permission;
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{

	Permission findByPermissionId(int permissionId);
	
}
