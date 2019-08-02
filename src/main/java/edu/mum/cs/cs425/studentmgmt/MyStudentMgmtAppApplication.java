package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TranscriptRepository transcriptRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s = new Student("000-61-0001", "Anna", "Lynn", "Galverston", 3.45f, LocalDate.of(2019, 4, 30));
		Student savedStudent1 = saveStudent(s);
		System.out.println("Saved Student: " + savedStudent1);
		
		Student s2 = new Student("000-61-0002", "Bob", "Lynn", "Smith",2.87f, LocalDate.of(2019, 5, 1));
		Student savedStudent2 = saveStudent(s2);
		System.out.println("Saved Student 2: " + savedStudent2);
		
		Transcript t1 = new Transcript ("BS Computer Science");
		Transcript saveTransript1 = saveTranscript(t1);
		System.out.println("Save Transcript 1: " + saveTransript1);
		
		s2.setTranscript(t1);
		savedStudent2 = saveStudent(s2);
		System.out.println("Saved Student 2 after set Transcript: " + savedStudent2.getTranscript());
		
		Classroom c1 = new Classroom("McLaughlin building", "M105");
		Classroom savedClassroom1 = saveClassroom(c1);
		System.out.println("Save Classroom 1: " + savedClassroom1);
		
		s2.setClassroom(c1);
		savedStudent2 = saveStudent(s2);
		System.out.println("Saved Student 2 after set Classroom: " + savedStudent2.getClassroom());
	}

	Student saveStudent(Student s) {
		return this.studentRepository.save(s);
	}
	
	Transcript saveTranscript(Transcript t) {
		return this.transcriptRepository.save(t);
	}
	Classroom saveClassroom(Classroom c) {
		return this.classroomRepository.save(c);
	}
}
