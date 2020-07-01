
public class NhanVienTheoThoiGian extends Staff {
	private int workTime;
	
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public NhanVienTheoThoiGian() {
		super();
	}
	public NhanVienTheoThoiGian(int workTime) {
		super();
		this.workTime = workTime;
	}
	@Override 
	public void importStaff() {
		super.importStaff();
		System.out.println("Nhập số giờ làm: ");
		workTime = scanner.nextInt();
	}
	@Override
	public double totalSalary() {
		if (workTime <=40) {
			this.salary = 20000*workTime;
		} else if (workTime > 40) {
			this.salary = (20000*40)+((workTime - 40)*20000)*1.5;
		}
		return this.salary;
		
	}
	@Override 
	public String toString() {
		return super.toString() + "\n Số giờ làm:" + this.workTime + "Lương: "+this.salary;
	}
	
}
