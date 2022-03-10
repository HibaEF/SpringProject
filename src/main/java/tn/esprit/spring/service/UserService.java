package tn.esprit.spring.service;

import tn.esprit.spring.entity.AvisUser;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.RoleName;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    List<User> retrivaAllUsers();
    User addUser(User u);
    User addAdminUser(User u);
    User addSimpleUser(User u);
    void delteUser(Long id);
    User updateUser(User u);
    Optional<User>retriveUser(Long id);
    Optional<User> FindUserByEmail(String email);
    boolean MailExists(String email);
    User Authenticate(String email,String password);
    boolean verifyPassword(String email,String password);
    User ResetPassword(String email,String password);
    Role getRolebyRoleName(RoleName role);
    User ChangeRole(RoleName role, Long id);
    User ChangeCategorie(CategorieUser categorie, Long id);
    User AssignFactureToUser(Facture F,Long idUser );
    Set<Facture> AfficherFacturesParUser(Long idUser);
    User AssignAvisToUser(AvisUser A, Long idUser );
    Set<AvisUser> AfficherAvisParUser(Long idUser);
}
