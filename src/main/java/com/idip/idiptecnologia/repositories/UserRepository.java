package com.idip.idiptecnologia.repositories;

import com.idip.idiptecnologia.models.entities.UserModel;
import com.idip.idiptecnologia.models.payload.response.UserResponse;
import com.idip.idiptecnologia.models.payload.response.UserSelectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID>{


    Optional<UserModel> findByUserEmail(String userEmail);

    @Query("SELECT u.id, u.fullName FROM UserModel  u ")
    Page<UserSelectResponse> findSelectedFields(Pageable pageable);


//    // if want certificate the expression comes with lower case use QUERY
//    @Query("SELECT u FROM UserModel AS u WHERE lower(u.userEmail) like lower(?1) ")
//    // "?1" takes the expression from params
//    List<UserResponse> findByUserEmail(String userEmail, Sort sort);

    // looking for in the start for an expression ...StartingWith
    List<UserResponse> findByUserEmailStartingWith(String userEmail);

    // looking for in the end for an expression ...EndingWith
    List<UserResponse> findByUserEmailEndingWith(String userEmail);

    // looking for if there is an expression in the content ...Containing
    List<UserResponse> findByUserEmailContaining(String userEmail);

    // For number use:
    // ...LessThan, ...LessThanEqual,
    // ...GreaterThan, GreaterThanEqual

    // It can concatenate with number and string: OR, AND
    // List<T> findByHabitantLessThanAndCityNameContaining(Integer habitant, string
    // cityName)

}
