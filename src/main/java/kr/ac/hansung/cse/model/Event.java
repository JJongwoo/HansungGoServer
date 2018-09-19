package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Event {

	private String id;
	private String name;
	private String major;
	private String year;
	private String q1;
	private String q2;
	private int sum;
	private String time;
}
