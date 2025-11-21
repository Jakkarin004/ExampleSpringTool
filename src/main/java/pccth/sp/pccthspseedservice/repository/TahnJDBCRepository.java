package pccth.sp.pccthspseedservice.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import net.sf.jasperreports.engine.util.ObjectUtils;
import pccth.sp.pccthspseedservice.model.TahnModel;
import pccth.sp.pccthspseedservice.utils.DateUtil;

@Repository
public class TahnJDBCRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<TahnModel> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM seeddb.tahn");
		
		List<TahnModel> list = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper(TahnModel.class));
		return list;
	}
	
	
//	public void findByNameJdbc(String firstname ,String lastname) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM seeddb.tahn WHERE 1=1");
//		
//		List<Object> queryArgs = new ArrayList<>();
//		
//		if(!ObjectUtils.isEmpty(firstname)) {
//			sql.append(" AND name = ?");
//			queryArgs.add(firstname);
//		}
//		
//		if(!ObjectUtils.isEmpty(lastname)) {
//			sql.append(" AND lastname = ?");
//			queryArgs.add(lastname);
//		}
//		
//		List<TahnModel> list = jdbcTemplate.query(sql.toString(),new Object[] {firstname},
//				new BeanPropertyRowMapper(TahnModel.class));
//		return list;
//	}
	
	
//	public void findAllNameJdbcTemplate(String name) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM seeddb.tahn WHERE name=:name");
//		
//		MapSqlParameterSource parameter = new MapSqlParameterSource();
////		parameter.addValue("name", name);
//		
//		if(!ObjectUtils.isEmpty(name)){
//			parameter.addValue("name",name);
//		}
//		
//		
//		List<TahnModel> list = jdbcTemplate.query(sql.toString(),parameter,
//				new BeanPropertyRowMapper(TahnModel.class));
//		return list;
//	}
	
//	public void findAllNameJdbcTemplate(String firstname,String lastname,String age) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM seeddb.tahn WHERE name=:name");
//		
//		MapSqlParameterSource parameter = new MapSqlParameterSource();
////		parameter.addValue("name", name);
//		
//		if(!ObjectUtils.isEmpty(firstname)){
//			parameter.addValue("fname",firstname);
//		}
//		
//		if(!ObjectUtils.isEmpty(lastname)){
//			parameter.addValue("lname",lastname);
//		}
//		
//		if(!ObjectUtils.isEmpty(age)){
//			parameter.addValue("age",age);
//		}
//		
//		
//		Object[] preparedStatementArgs = new Object[]
//		
//		
//		List<TahnModel> list = jdbcTemplate.query(sql.toString(),parameter,
//				new BeanPropertyRowMapper(TahnModel.class));
//		return list;
//	}
	
	
	
	public void saveData(TahnModel tahnModel) {
		
		//ดึง string ที่รับมาจาก frontend เช่น 01/12/2550
	    String buddhistDate = tahnModel.getBirtday();

	    //string → YYYYMMDD ค.ศ.
	    String christianDate = DateUtil.convertDDMMYYYYBuddhistYearToYYYYMMDDChristianYear(buddhistDate);

	    //แปลง YYYYMMDD → java.util.Date
	    Date utilDate = DateUtil.convertYYYYMMDDChristianYearToDate(christianDate);

	    //แปลง util.Date → java.sql.Date
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO seeddb.tahn(username,name,lastname,age,birtday,gender,create_date,update_date,update_by) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?,?)");
		
		jdbcTemplate.update(
				sql.toString()
				,tahnModel.getUsername()
				,tahnModel.getFirstname()
				,tahnModel.getLastname()
				,tahnModel.getAge()
				,sqlDate
				,tahnModel.getGender()
				,tahnModel.getCreateDate()
				,tahnModel.getUpdateDate()
				,tahnModel.getUpdateBy());
	
	}
	
}
