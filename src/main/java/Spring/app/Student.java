package Spring.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "sid")
	int student_id;
	@Column(name = "sname")
	String student_name;
	@Column(name = "scity")
	String student_city;
	@Column(name = "sage")
	int student_age;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_city() {
		return student_city;
	}

	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}

	public int getStudent_age() {
		return student_age;
	}

	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}

	public Student(int student_id, String student_name, String student_city, int student_age) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_city = student_city;
		this.student_age = student_age;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_city=" + student_city
				+ ", student_age=" + student_age + "]";
	}

}
