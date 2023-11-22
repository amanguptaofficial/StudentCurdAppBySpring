package Spring.app;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {

	private HibernateTemplate hiberTemplate;

	public HibernateTemplate getHiberTemplate() {
		return hiberTemplate;
	}

	public void setHiberTemplate(HibernateTemplate hiberTemplate) {
		this.hiberTemplate = hiberTemplate;
	}

	@Transactional
	public int insert(Student student) {
		Integer ans = (Integer) this.hiberTemplate.save(student);
		return ans;
	}

	public Student getStudentById(int id) {
		Student student = this.hiberTemplate.get(Student.class, id);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> loadAll = this.hiberTemplate.loadAll(Student.class);
		return loadAll;
	}

	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hiberTemplate.get(Student.class, id);
		this.hiberTemplate.delete(student);
	}
}
