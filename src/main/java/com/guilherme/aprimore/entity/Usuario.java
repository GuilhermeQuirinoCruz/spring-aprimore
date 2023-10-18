package com.guilherme.aprimore.entity;

import com.guilherme.aprimore.enums.Grupo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

@Getter
@Setter
// @ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue()
    private Long id;
    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;
    @Email
    @NotBlank(message = "O email não pode ser nulo")
    private String email;
    @NotBlank(message = "A senha não pode ser nula")
    private String senha;
    @Enumerated(EnumType.STRING)
    private Grupo grupo;
}
