package com.emilie.coffeeShopBackend.Mapper;

import com.emilie.coffeeShopBackend.Models.Dtos.UserDto;
import com.emilie.coffeeShopBackend.Models.Entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper {

    User userDtoToUser (UserDto userDto);

    @InheritInverseConfiguration
    UserDto userToUserDto (User user);

    UserDto userToUserDto(Optional<User> findById);


}
