import java.util.Scanner;

public class Staff {
	public String staffId, fullName, sex;
	public int age;
	protected double salary;
	Scanner scanner = new Scanner(System.in);

	public Staff() {
		super();
	}

	public Staff(String staffId, String fullName, String sex, int age, double salary) {
		super();
		this.staffId = staffId;
		this.fullName = fullName;
		this.sex = sex;
		this.age = age;
		this.salary = salary;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void importStaff() {
		System.out.println("Nhập mã nhân viên: ");
		staffId = scanner.nextLine();
		System.out.println("Nhập họ tên nhân viên: ");

		do {
			fullName = scanner.nextLine();
		} while (fullName.isEmpty() == true);
		try {
			while (checkFullName(fullName) == false) {
				System.out.println("vui lòng nhập lại");
				fullName = scanner.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Nhập giới tính: ");
		sex=scanner.nextLine();
		System.out.println("Nhập tuổi: ");
		age = scanner.nextInt();
	}

	public double totalSalary() {
		return 0;
	}

	@Override
	public String toString() {
		return "Mã nhân viên: " + this.staffId + ", Họ và tên: " + this.fullName + ", Giới tính: " + this.sex
				+ ", Tuổi:" + this.age;
	}

	public static boolean checkFullName(String s) throws Exception {

		// kiểm tra họ tên, họ tên chỉ chứa các ký tự từ a -> z và A -> Z
		if (s.matches("[a-z A-Z]{2,40}")) {
			return true;
		} else {
			return false;
		}

	}
}
