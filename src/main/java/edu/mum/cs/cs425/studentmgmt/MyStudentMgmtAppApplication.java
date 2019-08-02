package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		//Task 1
		Student s = new Student("000-61-0001", "Anna", "Lynn", "Galverston", 3.45f, LocalDate.of(2019, 4, 30));
		Student savedStudent1 = saveStudent(s);
		System.out.println("Saved Student: " + savedStudent1);
		
		//Task 2
		Student s2 = new Student("000-61-0002", "Bob", "Lynn", "Smith",2.87f, LocalDate.of(2019, 5, 1));
		Transcript t1 = new Transcript ("BS Computer Science");
		s2.setTranscript(t1);
		Student savedStudent2 = saveStudent(s2);
		System.out.println("Saved Student 2: " + savedStudent2 + " Transcript of Student 2: " +  savedStudent2.getTranscript());
		
		Classroom c1 = new Classroom("McLaughlin building", "M105");
		Student s3 = new Student("000-61-0003", "Mary", "", "Lee",3.87f, LocalDate.of(2019, 5, 10));
		Student s4 = new Student("000-61-0004", "Daisy", "", "Anna",3.70f, LocalDate.of(2019, 5, 14));
		s3.setClassroom(c1);
		s4.setClassroom(c1);
		List<Student> students = new ArrayList<Student>();
		students.add(s3);
		students.add(s4);
		c1.setStudents(students);
		
		Classroom savedClassroom1 = saveClassroom(c1);
		System.out.println("Save Classroom 1: " + savedClassroom1);
		for (Student stu: students) {
			System.out.println("Saved Students of class room c1:  " +stu);
		}
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
