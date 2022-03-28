package com.emilie.coffeeShop.Services.impl;


import com.emilie.coffeeShop.Exceptions.AddressNotFoundException;
import com.emilie.coffeeShop.Exceptions.ImpossibleDeleteUserException;
import com.emilie.coffeeShop.Exceptions.UserAlreadyExistsException;
import com.emilie.coffeeShop.Exceptions.UserNotFoundException;
import com.emilie.coffeeShop.Mapper.AddressMapper;
import com.emilie.coffeeShop.Mapper.UserMapper;
import com.emilie.coffeeShop.Models.Dtos.UserDto;
import com.emilie.coffeeShop.Models.Entities.User;
import com.emilie.coffeeShop.Repositories.UserRepository;
import com.emilie.coffeeShop.Services.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gunnm
 * @create 17/03/2022 - 21:00
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper userMapper, AddressMapper addressMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public UserDto getLoggedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto userDto = findByEmail(email);
        return userMapper.userToUserDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto findById(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        User user = optionalUser.get();
        return userMapper.userToUserDto(userRepository.findById(id));
    }

    @Override
    public UserDto save(UserDto userDto) throws UserAlreadyExistsException, AddressNotFoundException {

        isNewUserValid(userDto);
        User user = userMapper.userDtoToUser(userDto);
      /*  User user = userDtoToUser (UserDto);
        User userDtoToUser (UserDto userDto);*/
        user = userRepository.save(user);

        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public void isNewUserValid(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }
        if (userDto.getAddressDto() == null) {
            throw new AddressNotFoundException("Address not found");
        }
    }

    @Override
    public UserDto update(UserDto userDto) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (userDto.getAddressDto() == null) {
            throw new AddressNotFoundException("Address not found");
        }
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        User user = optionalUser.get();

        if (userDto.getEmail() != null) user.setEmail(userDto.getEmail());
        if (userDto.getFirstName() != null) user.setFirstName(userDto.getFirstName());
        if (userDto.getLastName() != null) user.setLastName(userDto.getLastName());
        if (userDto.getAddressDto() != null) user.setAddress(addressMapper.makeAddress(userDto.getAddressDto()));

        /* user = userRepository.save(user);*/
        return userMapper.userToUserDto(userRepository.save(user));

    }

    //TODO create Entity Order and check reasons why it could be impossible to delete a user
    @Override
    public boolean deleteById(Long id) throws UserNotFoundException, ImpossibleDeleteUserException {

        Optional<User> optionalUser = userRepository.findById(id);

    /*    if (!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found");
        } else if (optionalUser.get().getOrders().size() > 0){
            throw new ImpossibleDeleteUserException("This user "
            + id + "have existing orders");
        }try {
            userRepository.deleteById(id);
        }catch (Exception e) {
            return false;
        }*/

        return true;
    }

    @Override
    public UserDto findByEmail(String email) throws UserNotFoundException {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User " + email + "not found");
        }
        User user = optionalUser.get();
/*
        UserDto userDto = this.userMapper.userToUserDto(user);
*/
        return this.userMapper.userToUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = userMapper.userToUserDto(user);
            userDto.setPassword("");
            userDtos.add(userDto);
        }
        return userDtos;
    }

}
