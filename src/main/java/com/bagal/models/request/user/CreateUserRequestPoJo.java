package com.bagal.models.request.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateUserRequestPoJo {
    private String name;
    private String job;
}