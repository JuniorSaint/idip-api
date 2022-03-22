package com.idip.idiptecnologia.security.Services;

import com.idip.idiptecnologia.exceptions.PasswordInvalidException;
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

    public  UserDetails authenticate(UserModel userModel){
        UserDetails userDetails = loadUserByUsername(userModel.getUserEmail());
       boolean isMatchPassword = encoder.matches(userModel.getPassword(), userDetails.getPassword());

       if(isMatchPassword){
           return userDetails;
       }
       throw new PasswordInvalidException();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserEmail(username)
                                       .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return User.builder()
                   .username(user.getUserEmail())
                   .password(user.getPassword())
                   .roles(user.getUserType())
                   .build();
    }

}



