package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Event;
import kr.ac.hansung.cse.model.QuestList;
import kr.ac.hansung.cse.model.Sum;

@Repository
public class EventDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void login(String name, String id, String year, String major, String time, String phone) {
		
		String sqlStatement = "insert into user(name, id, year, major, time, phone) values (?, ?, ?, ?, ?, ?)";
  
		
		
		jdbcTemplate.update(sqlStatement, new Object[] { name, id, year, major, time, phone});

	}

	public void clearQ1(String name, String id, String year, String major, String time) {
		String sqlStatement = "update user set q1='완료!', time='" + time + "', q1time='" + time + "' where id = '" + id
				+ "'";

		jdbcTemplate.update(sqlStatement);
	}

	public void clearQ2(String name, String id, String year, String major, String time) {
		String sqlStatement = "update user set q2='완료!', time='" + time + "', q2time='" + time + "' where id = '" + id
				+ "'";

		jdbcTemplate.update(sqlStatement);
	}

	public void sum(String name, String id, String year, String major, String time) {
		String sqlStatement = "update user set sum=sum+1, time='" + time + "' where id= '" + id + "'";

		jdbcTemplate.update(sqlStatement);
	}

	public List<Event> getStatus() {
		
		String sqlStatement = "select * from user order by sum DESC";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Event>() {
			
			@Override
			public Event mapRow(ResultSet rs, int arg1) throws SQLException {
				
				Event event = new Event();
				event.setId(rs.getString("id"));
				event.setName(rs.getString("name"));
				event.setMajor(rs.getString("major"));
				event.setYear(rs.getString("year"));
				event.setQ1(rs.getString("q1"));
				event.setQ2(rs.getString("q2"));
				event.setSum(rs.getInt("sum"));
				event.setTime(rs.getString("time"));

				return event;
			}
		});

	}

	public List<QuestList> getQ1(String q1) {
		String sqlStatement = "select id, name, major, year, q1, q1time from user where q1='" + q1 + "' order by q1time ASC";

		return jdbcTemplate.query(sqlStatement, new RowMapper<QuestList>() {

			@Override
			public QuestList mapRow(ResultSet rs, int arg1) throws SQLException {

				QuestList quest = new QuestList();
				quest.setId(rs.getString("id"));
				quest.setName(rs.getString("name"));
				quest.setMajor(rs.getString("major"));
				quest.setYear(rs.getString("year"));
				quest.setQ1(rs.getString("q1"));
				quest.setQ1time(rs.getString("q1time"));

				return quest;
			}

		});
	}

	public List<QuestList> getQ2(String q2) {
		String sqlStatement = "select id, name, major, year, q2, q2time from user where q2='" + q2 + "' order by q2time ASC";

		
		return jdbcTemplate.query(sqlStatement, new RowMapper<QuestList>() {
			
			@Override
			public QuestList mapRow(ResultSet rs, int arg1) throws SQLException {

				QuestList quest = new QuestList();
				quest.setId(rs.getString("id"));
				quest.setName(rs.getString("name"));
				quest.setMajor(rs.getString("major"));
				quest.setYear(rs.getString("year"));
				quest.setQ2(rs.getString("q2"));
				quest.setQ2time(rs.getString("q2time"));

				return quest;
			}

		});
	}
	
	public List<Sum> viewSum(){
		String sqlStatement = "select id, name, major, year, sum, time from user order by sum desc";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<Sum>() {

			@Override
			public Sum mapRow(ResultSet rs, int arg1) throws SQLException {
				Sum sum = new Sum();
				sum.setId(rs.getString("id"));
				sum.setName(rs.getString("name"));
				sum.setMajor(rs.getString("major"));
				sum.setYear(rs.getString("year"));
				sum.setSum(rs.getInt("sum"));
				sum.setTime(rs.getString("time"));
				
				return sum;
			}
		
		
		});	
	}
}
