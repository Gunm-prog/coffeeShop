package com.emilie.coffeeShop.Mapper;

import com.emilie.coffeeShop.Models.Dtos.UserDto;
import com.emilie.coffeeShop.Models.Entities.User;
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
