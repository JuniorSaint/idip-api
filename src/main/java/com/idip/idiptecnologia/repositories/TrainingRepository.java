package com.idip.idiptecnologia.repositories;

import java.util.Optional;
import java.util.UUID;

import com.idip.idiptecnologia.models.entities.TrainingModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingModel, UUID> {

  Optional<TrainingModel> findById(UUID id);

}
