package com.servicedesk.api.entities.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(@NotBlank
                            String name,

                            @NotBlank
                            @Email
                            String email,

                            @NotBlank
                            String password) {
}
