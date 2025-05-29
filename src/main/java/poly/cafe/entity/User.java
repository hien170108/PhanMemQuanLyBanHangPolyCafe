package poly.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class User {
    private String username;
    private String password;
    private boolean enabled;
    private String fullname;
//    @Builder.Default
    private String photo = "photo.png";
    private boolean manager;
    private String email;

    public User() {
    }

    public User(String username, String password, boolean enabled, String fullname, boolean manager) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.fullname = fullname;
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// Constructor private để bắt buộc dùng Builder
    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.enabled = builder.enabled;
        this.fullname = builder.fullname;
        this.photo = builder.photo;
        this.manager = builder.manager;
        this.email = builder.email;
    }

    // Static inner Builder class
    public static class Builder {
        private String username;
        private String password;
        private boolean enabled;
        private String fullname;
        private String photo = "photo.png"; // default
        private boolean manager;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder manager(boolean manager) {
            this.manager = manager;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
