package com.idip.idiptecnologia.models.payload.response;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserSelectResponse {

  private UUID id;

  private String fullName;

  private String userName;
}
