package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;
    private String id;
    @NotBlank(message = "Phone number  cannot be empty")
    private String phoneNumber;
    @NotBlank(message = "Email cannot be empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;
}