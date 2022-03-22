package com.idip.idiptecnologia.services;

import com.idip.idiptecnologia.models.entities.UserModel;
import com.idip.idiptecnologia.models.payload.response.UserSelectResponse;
import com.idip.idiptecnologia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder pe;

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Transactional
    public UserModel save(UserModel userModel){
        try {
            var result = userModel;
            pe = new BCryptPasswordEncoder();
            result.setPassword(pe.encode(userModel.getPassword()));
            return userRepository.save(result);

        }catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public UserModel update(UserModel userModel) {
        try {
            var result = userModel;
            pe = new BCryptPasswordEncoder();
            result.setPassword(pe.encode(userModel.getPassword()));
            return userRepository.save(result);

        }catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
}
