package com.cydeo.convertor;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String, UserDTO> {

    UserService userService;

    public UserDTOConverter(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }
}


