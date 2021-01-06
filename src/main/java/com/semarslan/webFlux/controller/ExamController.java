package com.semarslan.webFlux.controller;

import com.semarslan.webFlux.entity.Exam;
import com.semarslan.webFlux.service.ExamService;
import com.semarslan.webFlux.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor //cons inj lombok
public class ExamController {

    private final ExamService examService;

    @GetMapping("1.0/exam/{id}")
    public ResponseEntity<Mono<Exam>> getExamById(@PathVariable("id") String id){
        final Mono<Exam> exam = examService.getExamById(id);
        return ResponseEntity.ok(exam);
    }

    @GetMapping("1.0/exam")
    public ResponseEntity<Flux<Exam>> getAllExams() {
        final Flux<Exam> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    @PostMapping("1.0/exam")
    public GenericResponse createExam(@RequestBody Exam exam) {
        examService.createExam(exam);
        return new GenericResponse("Todo created.");
    }

    @DeleteMapping("1.0/exam/{id}")
    public GenericResponse deleteExam(@PathVariable("id") String id) {
        examService.deleteExam(id);
        return new GenericResponse("Exam deleted");
    }
}
