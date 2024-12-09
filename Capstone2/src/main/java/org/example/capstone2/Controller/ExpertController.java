package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import org.example.capstone2.ApiResponse.ApiResponse;
import org.example.capstone2.Model.Course;
import org.example.capstone2.Model.Expert;
import org.example.capstone2.Service.ExpertService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/MyKnowledge-YourGrowth/expert")

public class ExpertController {

    private final ExpertService expertService;


    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/get")
    public ResponseEntity getExperts() {
        return ResponseEntity.status(200).body(expertService.getExperts());
    }

    @PostMapping("/add")
    public ResponseEntity addExpert(@RequestBody Expert expert, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        expertService.addExpert(expert);
        return ResponseEntity.status(200).body(new ApiResponse("Expert added successfully!"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateExpert(@PathVariable Integer id, @RequestBody @Valid Expert expert, Errors errors) {

        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        expertService.updateExpert(id, expert);

        return ResponseEntity.status(200).body(new ApiResponse("Expert updated successfully!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteExpert(@PathVariable Integer id) {

        expertService.deleteExpert(id);
        return ResponseEntity.status(200).body(new ApiResponse("Expert deleted successfully!"));

    }
    //End CRUD

    //-- recommend courses to a learner based on the number of completed sessions--

    @GetMapping("/recommended-courses/{userId}/{expertId}")
    public ResponseEntity recommendCoursesForLearner(@PathVariable Integer userId, @PathVariable Integer expertId) {

        List<Course> recommendedCourses = expertService.recommendCoursesForLearner(userId, expertId);
        return ResponseEntity.status(200).body(new ApiResponse(recommendedCourses.toString()));
    }


}
