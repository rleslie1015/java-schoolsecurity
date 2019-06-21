package com.lambdaschool.school;


import com.lambdaschool.school.model.Role;
import com.lambdaschool.school.model.User;
import com.lambdaschool.school.model.UserRoles;
import com.lambdaschool.school.repository.RoleRepository;
import com.lambdaschool.school.repository.UserRepository;
import com.lambdaschool.school.service.RoleService;
import com.lambdaschool.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {

        Role r2 = new Role("user");


        roleService.save(r2);



        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));


        rolerepos.save(r2);
        User u1 = new User("barnbarn", "password", users);


        userrepos.save(u1);

    }
}
