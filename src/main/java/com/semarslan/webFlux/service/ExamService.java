package com.semarslan.webFlux.service;

import com.semarslan.webFlux.entity.Exam;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ExamService {

    Mono<Exam> getExamById(String id);

    Flux<Exam> getAllExams();

    void createExam(Exam exam);

    void deleteExam(String id);
}
