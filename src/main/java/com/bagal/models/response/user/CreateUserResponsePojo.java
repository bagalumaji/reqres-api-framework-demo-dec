package com.bagal.models.response.user;

public class CreateUserResponsePojo {
    private String  name;
    private String   job;
    private String   id;
    private String createdAt;

    public CreateUserResponsePojo(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public CreateUserResponsePojo() {
    }

    public String getName() {
        return name;
    }

    public CreateUserResponsePojo setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public CreateUserResponsePojo setJob(String job) {
        this.job = job;
        return this;
    }

    public String getId() {
        return id;
    }

    public CreateUserResponsePojo setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CreateUserResponsePojo setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
