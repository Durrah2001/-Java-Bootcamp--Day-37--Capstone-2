package org.example.capstone2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "RequestSession")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;

    @Column(columnDefinition = "int")
    private Integer userId;

    @Column(columnDefinition = "int")
    private Integer sessionId;

    @NotEmpty(message = "Request status can not be empty!")
    @Pattern(regexp = "^(Pending|Approved|Rejected)$", message = "Request status must be either \"Pending\", or \"Approved\", or \"Rejected\".")
    @Column(columnDefinition = "varchar(10) not null")
    private String status;

    @JsonFormat
    @Column(columnDefinition = "DATE")
    private LocalDate requestDate;

    @Pattern(regexp = "^(https?|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,6}(/\\S*)?$", message = "Invalid URL format")
    @Column(columnDefinition = "varchar(40)")
    private String url;

    /////////////////////////////////


    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public @NotEmpty(message = "Request status can not be empty!") @Pattern(regexp = "^(Pending|Approved|Rejected)$", message = "Request status must be either \"Pending\", or \"Approved\", or \"Rejected\".") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Request status can not be empty!") @Pattern(regexp = "^(Pending|Approved|Rejected)$", message = "Request status must be either \"Pending\", or \"Approved\", or \"Rejected\".") String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public @Pattern(regexp = "^(https?|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,6}(/\\S*)?$", message = "Invalid URL format") String getUrl() {
        return url;
    }

    public void setUrl(@Pattern(regexp = "^(https?|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,6}(/\\S*)?$", message = "Invalid URL format") String url) {
        this.url = url;
    }
}







