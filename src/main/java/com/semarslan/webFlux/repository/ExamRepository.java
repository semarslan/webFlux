package com.semarslan.webFlux.repository;

import com.semarslan.webFlux.entity.Exam;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ExamRepository extends ReactiveMongoRepository<Exam, String> {

    Flux<Exam> findByTeacherName(String teacherName);
}
