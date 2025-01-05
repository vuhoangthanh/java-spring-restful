package vn.hoidanit.jobhunter.domain.dto;

public class RestloginDTO {
    private String accessToken;
    private UserLogin user;

    public static class UserLogin {
        private long id;
        private String name;
        private String email;

        public UserLogin() {
        }

        public UserLogin(long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserLogin getUser() {
        return user;
    }

    public void setUser(UserLogin user) {
        this.user = user;
    }

}
