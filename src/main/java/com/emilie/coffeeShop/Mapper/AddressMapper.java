package com.emilie.coffeeShop.Mapper;


import com.emilie.coffeeShop.Models.Dtos.AddressDto;
import com.emilie.coffeeShop.Models.Entities.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "city.name", target = "city")
    })
    AddressDto makeAdressDto (Address address);

    @InheritInverseConfiguration
    Address makeAddress (AddressDto addressDto);
}
