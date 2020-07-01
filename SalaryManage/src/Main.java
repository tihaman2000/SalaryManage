import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main extends Staff {
	static ArrayList<Staff> listStaff = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================================");
		System.out.println("1.Nhập danh sách nhân viên");
		System.out.println("2.Xuất danh sách nhân viên");
		System.out.println("3.Sửa nhân viên theo mã");
		System.out.println("4.Xóa nhân viên theo mã");
		System.out.println("5.Tìm kiếm nhân viên theo mã");
		System.out.println("6.Sắp xếp lương tăng dần");
		System.out.println("7.Sắp xếp lương giảm dần");
		System.out.println("==================================");

		Main choose = new Main();
		int c;
		while (true) {
			System.out.println("Chọn chức năng! ");
			c = scanner.nextInt();
			switch (c) {
			case 1:
				choose.importStaff();
				break;
			case 2:
				choose.exportStaff();
				break;
			case 3:
				choose.updateStaff();
				break;
			case 4:
				choose.deleteStaff();
				break;
			case 5:
				choose.searchById();
				break;
			case 6:
				choose.sortASC();
				break;
			case 7:
				choose.sortDESC();
				break;
			}
		}
	}

	@Override
	public void importStaff() {
		System.out.println("Nhập số nhân viên: ");
		int totalStaff = scanner.nextInt();
		Staff[] staff = new Staff[totalStaff];
		for (int i = 0; i < totalStaff; i++) {
			System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1) + " :");
			System.out.print("Chọn loại nhân viên: 1.Quản lí 2.Theo thời gian 3.Theo sản phẩm \n");
			int choose = scanner.nextInt();

			if (choose == 1) {
				staff[i] = new NhanVienQuanLy();
			} else if (choose == 2) {
				staff[i] = new NhanVienTheoThoiGian();
			} else if (choose == 3) {
				staff[i] = new NhanVienTheoSanPham();
			}
			staff[i].importStaff();
			staff[i].totalSalary();
//			Staff a = new Staff(staffId, fullName, sex, age, salary);
			listStaff.add(staff[i]);
		}
		for (int i = 0; i < listStaff.size(); i++) {
			System.out.println(staff[i].toString());
		}

	}

	public void exportStaff() {
		for (int i = 0; i < listStaff.size(); i++) {
			System.out.println(listStaff.get(i).toString());
		}
	}

	public void searchById() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên muốn tìm");
		String importId = sc1.nextLine();
		int check = 0;
		for (Staff nv : listStaff) {
			if (nv.getStaffId().equals(importId)) {
				System.out.println(nv.toString());
				check++;
			}
		}
		if (check == 0) {
			System.out.println("Mã nhân viên không tồn tại");
		}
	}

	public void deleteStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên cần xóa: ");
		String importId = sc.nextLine();
		for (int i = 0; i < listStaff.size(); i++) {
			if (listStaff.get(i).getStaffId().equals(importId)) {
				listStaff.remove(i);
				System.out.println("Đã xóa nhân viên staffId: " + importId + "\n");
				System.out.println("Số nhân viên còn lại :\n");
				exportStaff();
			}
		}
	}

	public void updateStaff() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Nhập mã nhân viên cần cập nhật: ");
		String importId = sc2.nextLine();
		for (Staff nv : listStaff) {
			if (nv.getStaffId().equals(importId)) {
				System.out.println("CÁC THÔNG TIN CÓ THỂ CHỈNH SỬA");
				System.out.println("1. Tên nhân viên: ");
				System.out.println("2. Giới tính: ");
				System.out.println("3. Tuổi: ");
				System.out.println("Mời bạn chọn thông tin cần sửa: ");
				Scanner sc3 = new Scanner(System.in);
				int choose = sc3.nextInt();
				if (choose == 1) {
					System.out.println("Cập nhật tên NV: ");
					nv.setFullName(sc2.nextLine());
				} else if (choose == 2) {
					System.out.println("Cập nhật giới tính: ");
					nv.setSex(sc2.nextLine());
				} else if (choose == 3) {
					System.out.println("Cập nhật tuổi: ");
					nv.setAge(scanner.nextInt());
				}
				listStaff.set(listStaff.indexOf(nv), nv);
			}
			exportStaff();
		}
	}

	public void sortASC() {
		Collections.sort(listStaff, new Comparator<Staff>() {
			public int compare1(Staff nv1, Staff nv2) {
				if (nv1.salary < nv2.salary) {
					return 1;
				} else {
					if (nv1.salary == nv2.salary) {
						return 0;
					} else {
						return -1;
					}
				}
			}

			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}

	public void sortDESC() {
		Collections.sort(listStaff, new Comparator<Staff>() {
			public int compare2(Staff nv1, Staff nv2) {
				if (nv1.salary < nv2.salary) {
					return -1;
				} else {
					if (nv1.salary == nv2.salary) {
						return 0;
					} else {
						return 1;
					}
				}
			}

			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

	}
}
