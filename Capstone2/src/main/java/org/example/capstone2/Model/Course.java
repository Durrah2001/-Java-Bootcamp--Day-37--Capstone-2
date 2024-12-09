package org.example.capstone2.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(columnDefinition = "int")
    private Integer expertId; // Refers to Expert's ID

    @NotEmpty(message = "Course title is required!")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String title;

    @NotEmpty(message = "Description is required!")
    @Size(max = 1000, message = "Description should not exceed 1000 characters!")
    @Column(columnDefinition = "varchar(1000) not null")
    private String description;

    @Min(value = 1, message = "Duration of course must be at least 1 hour!")
    @Column(columnDefinition = "int")
    private Integer durationHours;

    @Positive( message = "Rating must be positive number only!")
    @Min(0)
    @Max(5)
    @Column(columnDefinition = "int")
    private Integer rating;

    @Positive(message = "Price must be positive number!")
    @Column(columnDefinition = "DOUBLE")
    private Double price;


    /////////////////////////

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", durationHours=" + durationHours +
                ", rating=" + rating +
                '}';
    }


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }


    public @NotEmpty(message = "Course title is required!") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "Course title is required!") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "Description is required!") @Size(max = 1000, message = "Description should not exceed 1000 characters!") String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty(message = "Description is required!") @Size(max = 1000, message = "Description should not exceed 1000 characters!") String description) {
        this.description = description;
    }

    public @Min(value = 1, message = "Duration of course must be at least 1 hour!") Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(@Min(value = 1, message = "Duration of course must be at least 1 hour!") Integer durationHours) {
        this.durationHours = durationHours;
    }

    public @Positive(message = "Rating must be positive number only!") @Min(0) @Max(5) Integer getRating() {
        return rating;
    }

    public void setRating(@Positive(message = "Rating must be positive number only!") @Min(0) @Max(5) Integer rating) {
        this.rating = rating;
    }

    public @Positive(message = "Price must be positive number!") Double getPrice() {
        return price;
    }

    public void setPrice(@Positive(message = "Price must be positive number!") Double price) {
        this.price = price;
    }


}
