package com.idip.idiptecnologia.models.payload.response;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TrainingResponse {

  private UUID id;

  private String idUserName;

  private Date dateTraining;

  private Boolean isPaid;

  private List<ItemsToTrainingResponse> listTraining;
}
