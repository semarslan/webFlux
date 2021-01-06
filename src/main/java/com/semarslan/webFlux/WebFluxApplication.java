package com.semarslan.webFlux;

import com.semarslan.webFlux.entity.Exam;
import com.semarslan.webFlux.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor //cons-inj with lombok
public class WebFluxApplication {

	private final ExamRepository examRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebFluxApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void appStart() {
		IntStream.range(0, 10).mapToObj(this::createInitialExams)
				.map(examRepository::save).collect(Collectors.toList())
				.forEach(item->item.subscribe());
	}


	private Exam createInitialExams(int i) {
		return Exam.builder().teacherName("Teacher"+i).department("department"+i).
				classRoom("classroom" +i).startDate(Date.valueOf(LocalDate.now())).build();
	}
}
