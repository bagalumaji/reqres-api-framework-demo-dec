package com.bagal.models.request.user;

public class CreateUserRequestPoJo {
    private String name;
    private String job;

    public CreateUserRequestPoJo() {
    }

    public String getName() {
        return name;
    }

    public CreateUserRequestPoJo setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public CreateUserRequestPoJo setJob(String job) {
        this.job = job;
        return this;
    }

    public static CreateUserRequestBuilder builder() {
        return new CreateUserRequestBuilder();
    }

    public CreateUserRequestPoJo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static class CreateUserRequestBuilder {
        private String name;

        public String getName() {
            return name;
        }

        public CreateUserRequestBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getJob() {
            return job;
        }

        public CreateUserRequestBuilder setJob(String job) {
            this.job = job;
            return this;
        }

        private String job;

        public CreateUserRequestBuilder(String name, String job) {
            this.name = name;
            this.job = job;
        }
        public CreateUserRequestBuilder(){};

        public CreateUserRequestPoJo build() {
            return new CreateUserRequestPoJo(name,job);
        }



    }


}
