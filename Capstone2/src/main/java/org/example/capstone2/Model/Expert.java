package org.example.capstone2.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expertId;

    @NotEmpty(message = "Name is required!")
    private String name;

    @Email(message = "Email should be valid!")
    @NotEmpty(message = "Email is required!")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "Password is required!")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @NotEmpty(message = "Expertise area is required!")
    @Column(columnDefinition = "varchar(15) not null")
    private String expertiseArea;

    @Min(value = 1, message = "Experience years must be at least 1")
    @Column(columnDefinition = "int")
    private Integer experienceYears;

    @Min(value = 0, message = "Total sessions must be 0 or more!")
    @Column(columnDefinition = "int")

    private Integer totalSessions;

    /////////////////////


    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public @NotEmpty(message = "Name is required!") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name is required!") String name) {
        this.name = name;
    }

    public @Email(message = "Email should be valid!") @NotEmpty(message = "Email is required!") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid!") @NotEmpty(message = "Email is required!") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Password is required!") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    ) String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password is required!") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    ) String password) {
        this.password = password;
    }

    public @NotEmpty(message = "Expertise area is required!") String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(@NotEmpty(message = "Expertise area is required!") String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public @Min(value = 1, message = "Experience years must be at least 1") Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(@Min(value = 1, message = "Experience years must be at least 1") Integer experienceYears) {
        this.experienceYears = experienceYears;
    }


    public @Min(value = 0, message = "Total sessions must be 0 or more!") Integer getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(@Min(value = 0, message = "Total sessions must be 0 or more!") Integer totalSessions) {
        this.totalSessions = totalSessions;
    }
}
