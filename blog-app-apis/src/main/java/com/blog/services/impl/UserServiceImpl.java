package com.blog.services.impl;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repository.UserRepo;
import com.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=dtoToUser(userDto);
        User savedUser=this.userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User updateduser=this.userRepo.save(user);
        UserDto userDto1=userToDto(updateduser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos= users.stream().map(user->userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deletUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto){
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());

        User user=this.modelMapper.map(userDto,User.class);
        return  user;
    }

    private UserDto userToDto(User user){
//        UserDto userDto=new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setPassword(user.getPassword());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
