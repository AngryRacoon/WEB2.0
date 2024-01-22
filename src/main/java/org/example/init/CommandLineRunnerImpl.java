package org.example.init;


import org.example.dtos.*;
import org.example.models.enums.Category;
import org.example.models.enums.Engine;
import org.example.models.enums.Role;
import org.example.models.enums.Transmission;
import org.example.services.*;
import org.example.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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
    private AuthService authService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createAdminUser() {
        authService.createAdminUser();
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
        AddBrandDto b1 = new AddBrandDto("BYD");
        AddBrandDto b2 = new AddBrandDto("Lada");
        AddBrandDto bs1 = brandService.register(b1);
        AddBrandDto bs2 = brandService.register(b2);


        AddModelDto m1 = new AddModelDto("Han", Category.Car, "car1.png", 2015, 2022, bs1.getName());
        AddModelDto m2 = new AddModelDto("2122", Category.Car, "car1.png", 2015, 2022, bs2.getName());
        AddModelDto ms1 = modelService.register(m1);
        AddModelDto ms2 = modelService.register(m2);
    }
}
