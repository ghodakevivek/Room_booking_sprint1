package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.roombooking.config.LoginMesage;
import com.example.roombooking.dao.UserRepository;
import com.example.roombooking.entity.User;
import com.example.roombooking.model.LoginDTO;
import com.example.roombooking.model.UserDTO;
import com.example.roombooking.service.UserService;
import com.example.roombooking.util.UserConverter;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserConverter userConverter;
	
	
	// create user method
	@Override
	public UserDTO createUser(User user)
	{
		User u=userRepository.save(user);
		return userConverter.convertToUserDTO(u);
	}
	
	
	// Retrieve all users
	@Override
	public List<UserDTO> getAllUsers(){
		List<User> user=userRepository.findAll();
		
		//list of type DTO
		List<UserDTO> dtoList=new ArrayList<>();
		for(User u: user)
		{
			dtoList.add(userConverter.convertToUserDTO(u));
		}
		return dtoList;
	}
	
	
	// Retrieve user by id
	@Override
	public UserDTO getUserById(int id) {
		User u=userRepository.findByUserId(id);
		return userConverter.convertToUserDTO(u);
	}
	
	
	// Update user by id
	@Override
	public UserDTO updateUser(int id, User user) {
		User u=userRepository.findByUserId(id);
		
		u.setUserFirstName(user.getUserFirstName());
		u.setUserLastName(user.getUserLastName());
		u.setUserAadhar(user.getUserAadhar());
		u.setUserAge(user.getUserAge());
		u.setUserCity(user.getUserCity());
		u.setUserMobile(user.getUserMobile());
		u.setUserName(user.getUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserEmail(user.getUserEmail());
		
		
		User ur=userRepository.save(u);
		return userConverter.convertToUserDTO(ur);
	}
	
	
	// Delete user by id
	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User got deleted successFully";
	}


	@Override
	public UserDTO getUserById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	// Registration
	 @Override
	 public String addUser(UserDTO userDTO) {
		    User user = new User();
		    
		    user.setUserId(userDTO.getUserId());
		    user.setUserFirstName(userDTO.getUserFirstName());
		    user.setUserLastName(userDTO.getUserLastName());
		    user.setUserAadhar(userDTO.getUserAadhar());
		    user.setUserAge(userDTO.getUserAge());
		    user.setUserCity(userDTO.getUserCity());
		    user.setUserMobile(userDTO.getUserMobile());
		    user.setUserEmail(userDTO.getUserEmail());
		    user.setUserName(userDTO.getUserName());
		    user.setUserPassword(this.passwordEncoder.encode(userDTO.getUserPassword()));
		    
		    userRepository.save(user);
		    return user.getUserName();
		}
	    
	    
	    //Login
	    @Override
	    public LoginMesage  loginUser(LoginDTO loginDTO) {
	        String msg = "";
	        User user1 = userRepository.findByUserEmail(loginDTO.getUserEmail());
	        if (user1 != null) {
	            String password = loginDTO.getUserPassword();
	            String encodedPassword = user1.getUserPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            System.out.println(isPwdRight);
	            if (isPwdRight) {
	                Optional<User> user = userRepository.findByUserEmailAndUserPassword(loginDTO.getUserEmail(), encodedPassword);
	                if (user.isPresent()) {
	                    return new LoginMesage("Login Success", true);
	                } else {
	                    return new LoginMesage("Login Failed", false);
	                }
	            } else {
	                return new LoginMesage("password Not Match", false);
	            }
	        }else {
	            return new LoginMesage("Email not exits", false);
	        }
	    }


	
}
