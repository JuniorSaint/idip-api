package com.idip.idiptecnologia.models.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public @Data
class UserModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private String userImage;
    @Column(nullable = true)
    private boolean isActive;
    @Column(nullable = false)
    private String userType;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(nullable = true)
    private LocalDateTime birthdayDate;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
