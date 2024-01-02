package com.bagal.models.request.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestPoJo {
    private String name;
    private String job;
}
