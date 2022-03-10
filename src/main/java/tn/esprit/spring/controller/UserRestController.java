package tn.esprit.spring.controller;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.ModelUser;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.Profession;
import tn.esprit.spring.enumeration.RoleName;
import tn.esprit.spring.service.UserServiceImp;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserServiceImp userService;

    @GetMapping("/retrive-all-users")
    public List<User> getAllUsers(){
        return userService.retrivaAllUsers();
    }

    @GetMapping("/retrive-user/{user-id}")
    public Optional<User> retriveUser(@PathVariable("user-id") Long id){
        return userService.retriveUser(id);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User u){
        userService.addUser(u);
        return u;
    }
    @PostMapping("/add-admin-user")
    public User addAdminUser(@RequestBody User u){
        userService.addAdminUser(u);
        return u;
    }
    @PostMapping("/add-simple-user")
    public User addSimpleUser(@RequestBody User u){
        userService.addSimpleUser(u);
        return u;
    }

    @DeleteMapping("remove-user/{user-id}")
    public void deleteUser(@PathVariable("user-id") Long id){
        userService.delteUser(id);
    }

    @PutMapping( "modify-user")
    @ResponseBody
    public User modifyUser(@RequestBody User u){
        return userService.updateUser(u);
    }
/*    @PostMapping("modify-user-1")
    public User modifyUser1(@RequestBody ModelUser u){
        try{
        User user= new User();
        userService.assignModelToUser(u,user);
        return userService.updateUser(user);}
        catch (Exception e){
            System.out.println("exeption : "+e);
            return null;
        }
    }*/

    @GetMapping("/find-user-by-email")
    public Optional<User> find_user_by_email(@RequestParam String email){
        return userService.FindUserByEmail(email);
    }

    @GetMapping("/email-exists")
    public boolean MailExists(@RequestParam String email){
        return userService.MailExists(email);
    }

    @PostMapping(path = "/register",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String registerUser(@RequestBody User user){
        String msg="";
        Optional<User> userExists = userService.FindUserByEmail(user.getEmail());
        if (userExists.isPresent()){
            msg = "user already registered with the email provided";
        }
        else {
            msg="200 OK";
            userService.addUser(user);
        }
        return msg;
    }

    @PostMapping("/change-role-user")
    public User ChangeUserRole(@RequestBody RoleUser roleUser ){
       try {
           RoleName roleName = RoleName.valueOf(roleUser.get_Role());
           return userService.ChangeRole(roleName,roleUser.get_idUser());
       }
       catch (Exception e){
           System.out.println(e);
           System.out.println("role"+roleUser.get_Role());
           System.out.println("role"+roleUser.get_idUser());
           System.out.println("roleUser : "+roleUser.toString());
       }
       return null;
    }

    @PostMapping("/authenticate-user")
    public User Authenticate(@RequestBody ModelUser u){
        return  userService.Authenticate(u.getEmail(),u.getPassword());
    }

    @PostMapping("/reset-password-user")
    public User ResetPassword(@RequestBody ModelUser u){
        return  userService.ResetPassword(u.getEmail(),u.getPassword());
    }

    @PostMapping("/verify-password-user")
    public boolean verifyPassword(@RequestBody ModelUser u){
        return  userService.verifyPassword(u.getEmail(),u.getPassword());
    }
}


