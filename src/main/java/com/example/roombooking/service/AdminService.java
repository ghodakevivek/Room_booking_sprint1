package com.example.roombooking.service;



import com.example.roombooking.config.LoginMesage;
import com.example.roombooking.model.ALoginDTO;


public interface AdminService {


	 public LoginMesage  loginAdmin(ALoginDTO loginDTO);
}
