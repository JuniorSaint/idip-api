package com.idip.idiptecnologia.controllers;

import com.idip.idiptecnologia.models.entities.UserModel;
import com.idip.idiptecnologia.models.payload.request.UserRequestPost;
import com.idip.idiptecnologia.models.payload.request.UserRequestPut;
import com.idip.idiptecnologia.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/users")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @GetMapping
    public ResponseEntity<Page<UserModel>> findAllWithPage(@PageableDefault(page = 0, size = 10, sort = "userName", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRequestPost userRequestPost) {
        try {
            var userModel = new UserModel();
            BeanUtils.copyProperties(userRequestPost, userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id, @RequestBody @Valid UserRequestPut userRequestPut) {
        try {
            Optional<UserModel> userModelOptional = userService.findById(userRequestPut.getId());
            if (!userModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }
            var userModel = new UserModel();
            BeanUtils.copyProperties(userRequestPut, userModel);
            userModel.setId(userModelOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(userModel));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        try {
            Optional<UserModel> userModelOptional = userService.findById(id);
            if (!userModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
            userService.delete(userModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("User deleted with success.");
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

}
