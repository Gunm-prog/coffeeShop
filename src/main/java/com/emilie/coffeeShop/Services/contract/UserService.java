package com.emilie.coffeeShop.Services.contract;

import com.emilie.coffeeShop.Exceptions.UserAlreadyExistsException;
import com.emilie.coffeeShop.Exceptions.UserNotFoundException;
import com.emilie.coffeeShop.Models.Dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto getLoggedUser();

    UserDto findById(Long id) throws UserNotFoundException;

    UserDto save (UserDto userDto) throws UserAlreadyExistsException;

    void isNewUserValid (UserDto userDto);

    UserDto findByEmail (String email) throws UserNotFoundException;

    List<UserDto> findAll();

    boolean deleteById(Long id) throws UserNotFoundException;

    UserDto update (UserDto userDto) throws UserNotFoundException;
}
