package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.*;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =userRepository.findByEmail2(email);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }

    private List<GrantedAuthority>getUserAuthority(Set<Role> UserRoles){
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : UserRoles){
            roles.add(new SimpleGrantedAuthority(role.getRole().getAuthority()));
        }
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>(roles);
        return grantedAuthorities;
    }
}
