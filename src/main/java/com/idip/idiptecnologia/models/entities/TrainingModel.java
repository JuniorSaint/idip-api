package com.idip.idiptecnologia.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "training")
public @Data class TrainingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false)
  private String idUserName;
  @Column(nullable = false)
  private LocalDateTime dateTraining;
  @Column(nullable = false)
  private Boolean isPaid;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @JsonIgnoreProperties(value = { "trainingModel" }) // Fix problem cyclic reference
  @OneToMany(mappedBy = "trainingModel")
  private List<ItemsToTrainingModel> listTrainings;
}
