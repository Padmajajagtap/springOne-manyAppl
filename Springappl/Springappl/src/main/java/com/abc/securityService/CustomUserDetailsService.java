package com.abc.securityService;

import com.abc.model.UserCredentials;
import com.abc.repo.UserRepositry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepositry userRepositry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


            UserCredentials userCredentials = userRepositry.findByUsername(username);
            if(username== null)
            {
                throw new UsernameNotFoundException("User Not Found");
            }
            return new CustomUserDetails(userCredentials);

    }

}


