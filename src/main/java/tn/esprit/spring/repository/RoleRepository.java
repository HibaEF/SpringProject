package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.enumeration.RoleName;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    /*@Query("SELECT R FROM Role R WHERE R.role like ?1")
    Role findByRolename2(String rolename);*/

    Role findByRole(RoleName rolename);
}
