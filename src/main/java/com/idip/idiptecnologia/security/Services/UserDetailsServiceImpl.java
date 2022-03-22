package com.idip.idiptecnologia.security.Services;

import com.idip.idiptecnologia.models.entities.UserModel;
import com.idip.idiptecnologia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author raul@idip.com.br
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserEmail(username)
                                       .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//        if (user.isActive() != null) {
//            throw new UsernameNotFoundException("User " + user.getUserName() + " isn't active, contact the admin");
//        }
        return User.builder()
                   .username(user.getUserEmail())
                   .password(user.getPassword())
                   .roles(user.getUserType())
                   .build();
    }

}



