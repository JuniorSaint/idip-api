package com.idip.idiptecnologia.models.payload.response;

import java.util.Date;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponse {

  private UUID id;

  private String fullName;

  private String userName;

  private String userEmail;

  private String userImage;

  private Boolean isActive;

  private String userType;

  private Date birthdayDate;
}
