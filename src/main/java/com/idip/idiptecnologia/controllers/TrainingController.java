package com.idip.idiptecnologia.controllers;

import com.idip.idiptecnologia.services.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 60 * 60)
@RequestMapping("/v1/trainings")
public class TrainingController {

  @Autowired
  TrainingService service;

  @GetMapping
  public String helloWorld() {
    return "Hello world!!!";
  }
}
