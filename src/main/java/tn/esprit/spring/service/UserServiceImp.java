package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.RoleName;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository Rolerepository;

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository repository){this.userRepository=userRepository;
        this.Rolerepository = repository;
    }

    @Override
    public List<User> retrivaAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User addUser(User u) {
        Set<AvisUser> Avis= Collections.emptySet();
        Set<Facture> Factures=Collections.emptySet();
        u.setAvisUser(Avis);
        u.setFacture(Factures);
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        userRepository.save(u);
        return u;
    }

    @Override
    public User addAdminUser(User u) {
        Role roleUser =Rolerepository.findByRole(RoleName.ADMIN);
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        Set<Role> role=new HashSet<>();
        role.add(roleUser);
        u.setRole(role);
        return userRepository.save(u);
    }

    @Override
    public User addSimpleUser(User u) {
        Role roleUser =Rolerepository.findByRole(RoleName.SIMPLE);
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        Set<Role> role=new HashSet<>();
        role.add(roleUser);
        u.setRole(role);
        return userRepository.save(u);
    }

    @Override
    public void delteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User u) {
        /*Optional<User> UserExists = userRepository.findById(u.getIdUser());
        if (UserExists.isPresent()){
            User user =UserExists.get();
            if (!bCryptPasswordEncoder.matches(u.getPassword(),user.getPassword())){
                u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
            }
        }*/
        userRepository.save(u);
        return u;
    }

    @Override
    public Optional<User> retriveUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> FindUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean MailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public User Authenticate(String email, String password) {
        Optional<User> UserExists=userRepository.findByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            if (bCryptPasswordEncoder.matches(password,user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean verifyPassword(String email, String password) {
        Optional<User> UserExists=userRepository.findByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public User ResetPassword(String email, String password) {
        Optional<User> UserExists=userRepository.findByEmail(email);
        if(UserExists.isPresent()){
            User user=UserExists.get();
            user.setPassword(bCryptPasswordEncoder.encode(password));
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public Role getRolebyRoleName(RoleName role) {
        return Rolerepository.findByRole(role);
    }


    @Override
    public User ChangeRole(RoleName role, Long id) {
        Optional<User> U =userRepository.findById(id);
        Role roleUser =Rolerepository.findByRole(role);
        User user = U.get();
        if (user!=null&&roleUser!=null){
            user.getRole().clear();
            user.getRole().add(roleUser);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User ChangeCategorie(CategorieUser categorie, Long id) {
        return userRepository.ChangeCategorie(categorie,id);
    }

    @Override
    public User AssignFactureToUser(Facture F, Long idUser) {
        Optional<User> U =userRepository.findById(idUser);
        if (U.isPresent()){
           Set<Facture> Factures= U.get().getFacture();
           F.setUser(U.get());
           Factures.add(F);
           U.get().setFacture(Factures);
           userRepository.save(U.get());
           return U.get();
        }
        return null;
    }

    @Override
    public Set<Facture> AfficherFacturesParUser(Long idUser) {
        Optional<User> U =userRepository.findById(idUser);
        if (U.isPresent()){
            return U.get().getFacture();
        }
        return null;
    }

    @Override
    public User AssignAvisToUser(AvisUser A, Long idUser) {
        Optional<User> U =userRepository.findById(idUser);
        if (U.isPresent()){
            Set<AvisUser> Avis=U.get().getAvisUser();
            A.setUser_avis(U.get());
            Avis.add(A);
            U.get().setAvisUser(Avis);
            userRepository.save(U.get());
            return U.get();
        }
        return null;
    }

    @Override
    public Set<AvisUser> AfficherAvisParUser(Long idUser) {
        Optional<User> U =userRepository.findById(idUser);
        if (U.isPresent()){
            return U.get().getAvisUser();
        }
        return null;
    }

   /* public void assignModelToUser(ModelUser modelUser,User user) {
        try{
            user.setIdUser(modelUser.getIdUSer());
            user.setNom(modelUser.getNom());
            user.setPrenom(modelUser.getPrenom());
            user.setDateNaissance(modelUser.getDateNaissance());
            user.setEmail(modelUser.getEmail());
            user.setPassword(modelUser.getPassword());
            user.setCategorieUser(modelUser.getCategorieUser());
            user.setProfession(modelUser.getProfession());
            user.setPicture(modelUser.getPicture());
            user.setPhoneNumber(modelUser.getPhoneNumber());
            user.setAdresse(modelUser.getAdresse());
            user.setFacture(modelUser.getFacture());
            user.setAvisUser( modelUser.getAvisUser());
            RoleName roleName = RoleName.valueOf(modelUser.getRole());
            Role roleUser =Rolerepository.findByRole(roleName);
            user.getRole().clear();
            user.getRole().add(roleUser);
        }
        catch (Exception exception){
            System.out.println(exception);
        }

    }*/

}
