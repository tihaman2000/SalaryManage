
public class NhanVienTheoSanPham extends Staff {
	private int totalProduct;
	
	public NhanVienTheoSanPham() {
		super();
	}
	 public NhanVienTheoSanPham(int totalProduct) {
		 super();
		 this.totalProduct = totalProduct;
	 }
	public int getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}
	@Override 
	public void importStaff() {
		super.importStaff();
		System.out.println("Nhập số sản phẩm làm đc: ");
		totalProduct = scanner.nextInt();
	}
	@Override 
	public double totalSalary() {
		this.salary = 10000*this.totalProduct;
		return this.salary;
	}
	@Override 
	public String toString() {
		return super.toString()+"\n Số sản phẩm làm đc: "+this.totalProduct+", Lương: "+this.salary;
	}
}
