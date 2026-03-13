package Baitap.ntu65131861.nguyenhoangluu.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping("/info")
	public String XuatTT(ModelMap m) {
		m.addAttribute("mssv","65131861");
		m.addAttribute("HoTen","Nguyen Hoang Luu");
		m.addAttribute("NamSinh","02/07/2005");
		m.addAttribute("Gioitinh","Nam" );
		return "infoSV.html";
	}
}
