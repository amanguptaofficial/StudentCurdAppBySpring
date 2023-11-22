package Spring.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring/app/hello.xml");
		StudentDao bean = ac.getBean(StudentDao.class);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		while (run) {
			System.out.println("************Welcome to our Student Curd Application***********");
			System.out.println("================================================================");
			System.out.println("Press 1 to insert Student Data");
			System.out.println("Press 2 to display One Student Data");
			System.out.println("Press 3 to display All Student Data");
			System.out.println("Press 4 to delete Student Data");
			System.out.println("Press 5 to Exits");
			try {
				int choice = (Integer.parseInt(br.readLine()));
				switch (choice) {
				case 1:
					System.out.println("Enter Student Id:");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Enter Student Name:");
					String name = br.readLine();
					System.out.println("Enter Student City:");
					String city = br.readLine();
					System.out.println("Enter Student Age:");
					int age = Integer.parseInt(br.readLine());
					Student student = new Student(id, name, city, age);
					int ans = bean.insert(student);
					System.out.println(ans + " Successfully student Added !!");
					System.out.println("=======================================");
					break;
				case 2:
					System.out.println("Enter Student Id:");
					int stuid = Integer.parseInt(br.readLine());
					Student studentById = bean.getStudentById(stuid);
					System.out.println("ID:: " + studentById.getStudent_id());
					System.out.println("NAME:: " + studentById.getStudent_name());
					System.out.println("CITY:: " + studentById.getStudent_city());
					System.out.println("AGE:: " + studentById.getStudent_age());
					System.out.println("==============================================");
					break;
				case 3:
					List<Student> allStudent = bean.getAllStudent();
					for (Student stu : allStudent) {
						System.out.println("ID: " + stu.getStudent_id());
						System.out.println("NAME: " + stu.getStudent_name());
						System.out.println("CITY:: " + stu.getStudent_city());
						System.out.println("AGE:: " + stu.getStudent_age());
						System.out.println("==============================================");
					}
					break;
				case 4:
					System.out.println("Enter Student ID::");
					int sid = Integer.parseInt(br.readLine());
					bean.deleteStudent(sid);
					System.out.println("deleted Student Successfully:");
					System.out.println("==================================================");
					break;
				case 5:
					run = false;
					System.out.println("Thank you for using our Application.....!");
					System.out.println("===================================================");
					break;
				default:
					System.out.println("Invailid Choice try again later....::");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			{

			}
		}
	}
}
