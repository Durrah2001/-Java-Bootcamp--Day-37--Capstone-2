package org.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Check(constraints = "status='In Progress' or status='Completed'")
public class LearningPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer learningPathId;

    @Column(columnDefinition = "int")
    private Integer userId; // Refers to User's ID (Learner)

    @PositiveOrZero(message = "Completed sessions must be 0 or greater!")
    @Column(columnDefinition = "int")
    private Integer completedSessions;

    @PositiveOrZero(message = "Completed courses must be 0 or greater!")
    @Column(columnDefinition = "int")
    private Integer completedCourses;

    @NotEmpty(message = "Path learning status is required!")
    @Pattern(regexp = "^(In Progress|Completed)$", message = "Status must be In Progress or Completed!")
    @Column(columnDefinition = "varchar(13) not null")
    private String status;

    @PositiveOrZero(message = "Progress percentage cannot be negative!")
    @Max(value = 100, message = "Progress percentage cannot exceed 100!")
    @Column(columnDefinition = "int")
    private Integer progressPercentage;

    @Column(columnDefinition = "DATE")
    private LocalDate lastInteractiveDate;

    ////////////////////


    public Integer getLearningPathId() {
        return learningPathId;
    }

    public void setLearningPathId(Integer learningPathId) {
        this.learningPathId = learningPathId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public @PositiveOrZero(message = "Completed sessions must be 0 or greater!") Integer getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(@PositiveOrZero(message = "Completed sessions must be 0 or greater!") Integer completedSessions) {
        this.completedSessions = completedSessions;
    }

    public @PositiveOrZero(message = "Completed courses must be 0 or greater!") Integer getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(@PositiveOrZero(message = "Completed courses must be 0 or greater!") Integer completedCourses) {
        this.completedCourses = completedCourses;
    }

    public @NotEmpty(message = "Path learning status is required!") @Pattern(regexp = "^(In Progress|Completed)$", message = "Status must be In Progress or Completed!") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Path learning status is required!") @Pattern(regexp = "^(In Progress|Completed)$", message = "Status must be In Progress or Completed!") String status) {
        this.status = status;
    }

    public @PositiveOrZero(message = "Progress percentage cannot be negative!") @Max(value = 100, message = "Progress percentage cannot exceed 100!") Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(@PositiveOrZero(message = "Progress percentage cannot be negative!") @Max(value = 100, message = "Progress percentage cannot exceed 100!") Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDate getLastInteractiveDate() {
        return lastInteractiveDate;
    }

    public void setLastInteractiveDate(LocalDate lastInteractiveDate) {
        this.lastInteractiveDate = lastInteractiveDate;
    }
}
