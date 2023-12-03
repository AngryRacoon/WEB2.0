package org.example.init;


import org.example.dtos.*;
import org.example.models.enums.Category;
import org.example.models.enums.Engine;
import org.example.models.enums.Role;
import org.example.models.enums.Transmission;
import org.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }



    private void seedData() throws IOException {
//
//        BrandDto b1 = new BrandDto("BYD");
//        BrandDto b2 = new BrandDto("Lada");
//        BrandDto bs1 = brandService.register(b1);
//        BrandDto bs2 = brandService.register(b2);
//
//
//        ModelDto m1 = new ModelDto("Han", Category.Car, "car1.png", 2015, 2022, bs1);
//        ModelDto ms1 = modelService.register(m1);
//        ModelDto m2 = new ModelDto("Priora",Category.Car, "car2.png", 2001, 2011,bs2);
//        ModelDto ms2 = modelService.register(m2);
//
//
//
//
        UserRoleDto ur1 = new UserRoleDto(Role.ADMIN);
        UserRoleDto ur2 = new UserRoleDto(Role.USER);
        UserRoleDto urs1 = userRoleService.register(ur1);
        UserRoleDto urs2 = userRoleService.register(ur2);
//
//        UserDto u1 = new UserDto("Aboba", "qwerty", "Ivan", "Ivanov", true, "u1.png", urs1);
//        UserDto u2 = new UserDto("fdvjn", "1234567", "Petr", "Petrov", true, "u2.png", urs2);
//        UserDto us1 = userService.register(u1);
//        UserDto us2  = userService.register(u2);
//
//        OfferDto o1 = new OfferDto("jdjdsv", Engine.ELECTRIC, "jdsfjjdsf", 1234, BigDecimal.valueOf(100000), Transmission.AUTOMATIC, 2023, ms1, us1 );
//        OfferDto o2 = new OfferDto("jndjvlxdire", Engine.GASOLINE, "jnxvjnds.png", 1234, BigDecimal.valueOf(500000), Transmission.AUTOMATIC, 2023, ms2, us2 );
//        OfferDto os1 = offerService.register(o1);
//        OfferDto os2  = offerService.register(o2);
//        userService.expel(us1);
    }
}
