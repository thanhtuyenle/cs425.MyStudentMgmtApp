package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transcript")
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transcriptId;
	
	@Column(nullable = false)
	private String degreeTitle;
	
//	@OneToOne(mappedBy = "transcript")
//	private Student student;
	
	public Transcript() {
		super();
	}
	public Transcript(Long transcriptId, String degreeTitle) {
		this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
	}
	public Transcript(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	public Long getTranscriptId() {
		return transcriptId;
	}
	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	@Override
	public String toString() {
		return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
	}
	
}
