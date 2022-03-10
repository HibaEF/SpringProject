package tn.esprit.spring.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
    ADMIN,SIMPLE,BLOCKED;
    @Override
    public String getAuthority() {
        return "ROLE_"+name();
    }
}
