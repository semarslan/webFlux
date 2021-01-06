package com.semarslan.webFlux.service.impl;

import com.semarslan.webFlux.entity.Exam;
import com.semarslan.webFlux.repository.ExamRepository;
import com.semarslan.webFlux.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor  //Constructor injection Lombok like NonNull fields
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Mono<Exam> getExamById(String id) {
        return examRepository.findById(id);
    }

    /**
     * @return
     */
    @Override
    public Flux<Exam> getAllExams() {
        return examRepository.findAll();
    }

    /**
     * @param exam
     */
    @Override
    public void createExam(Exam exam) {
        final Exam createExam = Exam.builder().teacherName(exam.getTeacherName()).
                classRoom(exam.getClassRoom()).department(exam.getDepartment()).
                startDate(new Date()).build();
        examRepository.save(createExam).subscribe();
    }

    /**
     * @param id
     */
    @Override
    public void deleteExam(String id) {
        examRepository.deleteById(id).subscribe();
    }
}
