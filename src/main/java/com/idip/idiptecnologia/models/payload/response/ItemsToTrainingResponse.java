package com.idip.idiptecnologia.models.payload.response;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemsToTrainingResponse {

  private UUID id;

  private String exerciseType;

  private Integer weight;

  private Integer amountRepetition;
}
