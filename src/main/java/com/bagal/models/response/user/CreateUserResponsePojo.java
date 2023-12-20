package com.bagal.models.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserResponsePojo {
    private String  name;
    private String   job;
    private String   id;
    private String createdAt;
}
