
public class NhanVienQuanLy extends Staff {
	public NhanVienQuanLy() {
		super();
	}
	@Override
	public double totalSalary() {
		this.salary = 15000000;
		return this.salary;
	}
	@Override
	public String toString() {
		return super.toString() +"\n Lương: "+ this.salary;
	}
}
