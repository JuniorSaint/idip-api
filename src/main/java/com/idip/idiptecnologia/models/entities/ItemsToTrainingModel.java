package com.idip.idiptecnologia.models.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item_to_training")
public @Data class ItemsToTrainingModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String exerciseType;
	@Column(nullable = false)
	private Integer weight;
	@Column(nullable = false)
	private Integer amountRepetition;
	@ManyToOne
	@JoinColumn(name = "trainingId", referencedColumnName = "id")
	private TrainingModel trainingModel;
}