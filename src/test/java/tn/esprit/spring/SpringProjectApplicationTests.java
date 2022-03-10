package tn.esprit.spring;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.Profession;
import tn.esprit.spring.enumeration.RoleName;
import tn.esprit.spring.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class SpringProjectApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() throws ParseException {
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        User u1 = new User("jesser","dhieb",date,"jessser@gmail.com", "123", CategorieUser.Prenuim, Profession.Etudiant);
        userService.addUser(u1);*/
        //Role r =new Role(2L, RoleName.SIMPLE);
        //userService.ChangeRole(RoleName.SIMPLE, 1L);
    }

}
