package com.pluralsight.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Ride;
import com.pluralsight.repository.util.RideRowMapper;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Ride createRide(Ride ride) {
		jdbcTemplate.update("insert into ride (name, duration) values (?,?)", ride.getName(), ride.getDuration());
		
//		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
//		
//		List<String> columns = new ArrayList<>();
//		columns.add("name");
//		columns.add("duration");
//		
//		insert.setTableName("Ride");
//		insert.setColumnNames(columns);
//		
//		Map<String, Object> data = new HashMap<>();
//		data.put("name", ride.getName());
//		data.put("duration", ride.getDuration()); 
//		
//		insert.setGeneratedKeyName("id"); 
//		
//		Number key = insert.executeAndReturnKey(data); 
//		
//		System.out.println(key);
		
		return null; 
	}
	
	@Override
	public List<Ride> getRides() {
		
		List<Ride> rides = jdbcTemplate.query("select * from ride", new RideRowMapper());
		
		return rides;
	}
	
}
