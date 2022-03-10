package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.Role;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT U FROM User U WHERE U.email like ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT U FROM User U WHERE U.email like %?1")
    User findByEmail2(String email);

    @Modifying
    @Query("UPDATE User U SET U.CategorieUser=?1 WHERE U.idUser=?2")
    User ChangeCategorie(CategorieUser categorie, Long id);
}
