package com.idip.idiptecnologia.models.payload.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

public @Data class UserRequestPost {

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
  private boolean isActive;
  @NotEmpty(message = "Field 'userType' can't be empty")
  private String userType;

  private LocalDateTime birthdayDate;
}
