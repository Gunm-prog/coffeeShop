package com.emilie.coffeeShopBackend.Mapper;

import com.emilie.coffeeShopBackend.Models.Dtos.AddressDto;
import com.emilie.coffeeShopBackend.Models.Entities.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//TODO HOW TO MAP A @EMBEDDED
@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "city.name", target = "city")
    })
    AddressDto makeAddressDto (Address address);

    @InheritInverseConfiguration
    Address makeAddress (AddressDto addressDto);
}
