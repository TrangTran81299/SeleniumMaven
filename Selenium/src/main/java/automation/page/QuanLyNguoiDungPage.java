package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class QuanLyNguoiDungPage {
	private WebDriver driver;
	@FindBy(xpath = "//button[text() = 'Thêm mới']") WebElement btnThemMoi;
	@FindBy(name = "username") WebElement textHoVaTen;
	@FindBy(name = "email") WebElement textEmail;
	@FindBy(name = "phone_number") WebElement textSDT;
	@FindBy(name = "department_id") WebElement dropdownPhongBan;
	@FindBy(name = "role_id") WebElement dropdownChucDanh;
	@FindBy(name = "workarea_id") WebElement dropdownKhuVucLamViec;
	@FindBy(name = "code_user") WebElement maNguoiDung;
	@FindBy(xpath = "//button[text() = 'Lưu']") WebElement btnLuu;
	@FindBy(xpath = "//button[text() = 'Thêm']") WebElement btnThem;
	
	public QuanLyNguoiDungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Them nguoi dung
	public void ThemNguoiDung(String hovaten, String email, String sdt, String phongban, String chucdanh, String khulv, String maND) {
		btnThemMoi.click();
		textHoVaTen.sendKeys(hovaten);
		textEmail.sendKeys(email);
		textSDT.sendKeys(sdt);
		Select selectPB = new Select(dropdownPhongBan);
		selectPB.selectByValue(phongban);
		Select selectCD = new Select(dropdownChucDanh);
		selectCD.selectByValue(chucdanh);
		Select selectKVLV = new Select(dropdownKhuVucLamViec);
		selectKVLV.selectByValue(khulv);
		maNguoiDung.sendKeys(maND);
		btnLuu.click();
	}
	
	//Them nguoi dung thanh cong
	public void ThemNguoiDungThanhCong() {
		btnThem.click();
	}

	
	//Xoa nguoi dung
}
