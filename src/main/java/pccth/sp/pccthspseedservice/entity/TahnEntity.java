package pccth.sp.pccthspseedservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tahn",catalog="seeddb") //name="tahn",catalog="seeddb" ชื่อตารางของเรา และของตัวหลัก
public class TahnEntity {
	private Integer id;
	private String username;
	private String name;
	private String lastname;
	private Integer age;
	private Date birtday;
	private String gender;
	private Date createDate;
	private Date updateDate;
	private String updateBy;
	
	public TahnEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TahnEntity(Integer id, String username, String name, String lastname, Integer age, Date birtday, String gender,
			Date createDate, Date updateDate, String updateBy) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.birtday = birtday;
		this.gender = gender;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true , nullable = false )
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "username")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Column(name = "name")
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "birtday")
	public Date getBirtday() {
		return birtday;
	}


	public void setBirtday(Date birtday) {
		this.birtday = birtday;
	}


	@Column(name = "gender")
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}



	@Column(name = "update_by")
	public String getUpdateBy() {
		return updateBy;
	}


	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
	
	
}
