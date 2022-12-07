package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.User;
import net.servicelodge.servicelodge.models.UserWithRoles;
import net.servicelodge.servicelodge.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        System.out.println(new UserWithRoles(user).getFirst_Name());
        return new UserWithRoles(user);
    }
}