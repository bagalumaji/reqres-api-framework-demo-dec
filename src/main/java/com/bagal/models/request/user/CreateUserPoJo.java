package com.bagal.models.request.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateUserPoJo {
    private String name;
    private String job;
}
