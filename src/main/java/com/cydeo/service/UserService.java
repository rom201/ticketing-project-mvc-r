package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String>{

    List<UserDTO> findManagers();


//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void delete(UserDTO user); was delted
//    void deleteById(String username);

}
