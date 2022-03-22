package com.idip.idiptecnologia.models.payload.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

public @Data class TrainingRequestPost {

  @NotEmpty(message = "Field 'idUserName' can't be empty")
  private String idUserName;
  @NotEmpty(message = "Field 'dateTraining' can't be empty")
  private Date dateTraining;
  @NotEmpty(message = "Field 'isPaid' can't be empty")
  private Boolean isPaid;
  @JsonDeserialize
  private List<ItemsToTrainingRequestPost> listTraining;
}

