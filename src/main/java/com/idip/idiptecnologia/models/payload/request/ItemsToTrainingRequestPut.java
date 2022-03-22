package com.idip.idiptecnologia.models.payload.request;

import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

public @Data class ItemsToTrainingRequestPut {

  @NotEmpty(message = "Field 'id' can't be empty")
  private UUID id;
  @NotEmpty(message = "Field 'exerciseType' can't be empty")
  private String exerciseType;
  @NotEmpty(message = "Field 'weight' can't be empty")
  private Integer weight;
  @NotEmpty(message = "Field 'amountRepetition' can't be empty")
  private Integer amountRepetition;
  @NotEmpty(message = "Field 'trainingId' can't be empty")

  private TrainingRequestPost trainingRequest;
}
