package com.idip.idiptecnologia.models.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialRequest{
    private String login;
    private String password;
}