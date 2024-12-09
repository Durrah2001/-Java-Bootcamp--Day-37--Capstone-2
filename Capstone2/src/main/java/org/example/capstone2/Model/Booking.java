package org.example.capstone2.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "BookingCourses")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(columnDefinition = "int")
    private Integer userId; // Refers to User's ID


    @Column(columnDefinition = "int")
    private Integer courseId; // Refers to Course's ID

    @JsonFormat
    @Column(columnDefinition = "DATE")
    private LocalDate bookingDate;

    @NotEmpty(message = "Status is required!")
    @Pattern(regexp = "^(Pending|Confirmed)$", message = "Status must be Pending, Confirmed")
    @Column(columnDefinition = "varchar(12) not null")
    private String status;


    // Default to false (not awarded)
    @Column(columnDefinition = "boolean default false")
    private Boolean hasCourseCertificate;

    /////////////////////


    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }


    public @NotEmpty(message = "Status is required!") @Pattern(regexp = "^(Pending|Confirmed)$", message = "Status must be Pending, Confirmed") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Status is required!") @Pattern(regexp = "^(Pending|Confirmed)$", message = "Status must be Pending, Confirmed") String status) {
        this.status = status;
    }

    public Boolean getHasCourseCertificate() {
        return hasCourseCertificate;
    }

    public void setHasCourseCertificate(Boolean hasCourseCertificate) {
        this.hasCourseCertificate = hasCourseCertificate;
    }



}

