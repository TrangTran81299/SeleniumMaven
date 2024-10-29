package automation.testsuite;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNhanVien {
	@BeforeMethod
	private void init() {
		System.out.println("This is before method");
	}

	@Test
	private void nhapNhanVien() {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Nhập số nhân viên: ");
		n = sc.nextInt();
		NhanVien[] nv = new NhanVien[n];
		for (int i = 0; i < n; i++) {
			NhanVien nhanVien = new NhanVien();
			System.out.println("Nhập tên nhân viên thứ " + (i + 1) + ":");
			nhanVien.setTenNhanVien(sc.next());
			nv[i] = nhanVien;
		}

		System.out.println("Danh sách nhân viên: ");
		for (NhanVien nhanVien : nv) {
			System.out.println(nhanVien.getTenNhanVien());
		}
		
		Assert.assertEquals(n, nv.length);
	}
}
