package kr.ac.hansung.cse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.EventDao;
import kr.ac.hansung.cse.model.Event;
import kr.ac.hansung.cse.model.QuestList;
import kr.ac.hansung.cse.model.Sum;

@Service
public class EventService {

	@Autowired
	EventDao eventDao;
	
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	public void login(String name, String id, String year, String major, String phone) {	
		Date currentTime = new Date();
		String time = timeFormat.format(currentTime);
		eventDao.login(name, id, year, major, time, phone);
	}
	
	public void clearQ1(String name, String id, String year, String major) {
		Date currentTime = new Date();
		String time = timeFormat.format(currentTime);
		eventDao.clearQ1(name, id, year, major, time);
	}
	
	public void claarQ2(String name, String id, String year, String major) {
		Date currentTime = new Date();
		String time = timeFormat.format(currentTime);
		eventDao.clearQ2(name, id, year, major, time);
	}
	
	public void sum(String name, String id, String year, String major) {
		Date currentTime = new Date();
		String time = timeFormat.format(currentTime);
		eventDao.sum(name, id, year, major, time);
	}
	
	public List<Event> getStatus() {
		return eventDao.getStatus();
	}
	
	public List<QuestList> getQ1(String q1){
		return eventDao.getQ1(q1);
	}
	
	public List<QuestList> getQ2(String q2){
		return eventDao.getQ2(q2);
	}
	
	public List<Sum> viewSum(){
		return eventDao.viewSum();
	}
}
