package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import org.example.capstone2.ApiResponse.ApiResponse;
import org.example.capstone2.Model.Request;
import org.example.capstone2.Service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/MyKnowledge-YourGrowth/request-session")

public class RequestController {

    private final RequestService requestService;


    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping("/get")
    public ResponseEntity getRequests() {

        return ResponseEntity.status(200).body(requestService.getRequests());
    }

    @PostMapping("/add")
    public ResponseEntity addRequest(@RequestBody @Valid Request request, Errors errors) {

        if (errors.hasErrors())
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());

        requestService.createRequest(request);

        return ResponseEntity.status(200).body(new ApiResponse("Session request created successfully!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRequest(@PathVariable Integer id, @RequestBody @Valid Request request, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        requestService.updateRequest(id, request);
        return ResponseEntity.status(200).body(new ApiResponse("Session request updated successfully!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id) {

        requestService.deleteRequest(id);
        return ResponseEntity.status(200).body(new ApiResponse("Request deleted successfully!"));

    }

    //End CRUD


}
