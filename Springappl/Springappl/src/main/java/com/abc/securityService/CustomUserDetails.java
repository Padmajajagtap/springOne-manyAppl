package com.abc.securityService;

import com.abc.model.UserCredentials;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;


public class CustomUserDetails implements  UserDetails{

        private UserCredentials userCredentials;

        public CustomUserDetails(UserCredentials userCredentials) {
            super();
            this.userCredentials = userCredentials;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority(userCredentials.getRole()));
        }

        @Override
        public String getPassword() {
            return userCredentials.getPassword();
        }

        @Override
        public String getUsername() {
            return userCredentials.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }


