package com.ayp.sms.domain;
/**
 * 
 * @author rana
 * 
 */

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the timeTable database table.
 * 
 */
@Entity
@Table(name="timeTable")
public class TimeTable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, name="id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="class", nullable=false)
	private Sections section;

	@OneToMany(mappedBy="id")
	private List<TimeTableDetail> timeTableDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

	public List<TimeTableDetail> getTimeTableDetails() {
		return timeTableDetails;
	}

	public void setTimeTableDetails(List<TimeTableDetail> timeTableDetails) {
		this.timeTableDetails = timeTableDetails;
	}
}