package com.idip.idiptecnologia.models.payload.request;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

public @Data class UserRequestPut {

//  @NotEmpty(message = "Field 'Id' can't be empty")
  private UUID id;
  @NotEmpty(message = "Field 'fullName' can't be empty")
  private String fullName;
  @NotEmpty(message = "Field 'userName' can't be empty")
  private String userName;
  @NotEmpty(message = "Field 'userEmail' can't be empty")
  @Email(message = "Format field 'userEmail' is wrong")
  private String userEmail;
  @NotEmpty(message = "Field 'password' can't be empty")
  private String password;

  private String userImage;
//  @NotEmpty(message = "Field 'isActive' can't be empty")
  private Boolean isActive;
  @NotEmpty(message = "Field 'userType' can't be empty")
  private String userType;

  private LocalDateTime birthdayDate;
}
