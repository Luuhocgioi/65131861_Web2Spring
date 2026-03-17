package Baitap.ntu65131861.nguyenhoangluu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SinhVienController {
	
	private List<SinhVien> dsSinhVien = new ArrayList<>();
@GetMapping("/") 
	public String NhapTT(ModelMap m) {
	m.addAttribute("sv",new SinhVien());
	return "nhapTT";
}
@PostMapping("/luuSV")
	public String LuuSV(@ModelAttribute("sv") SinhVien sv) {
	dsSinhVien.add(sv);
	return "redirect:/hien-thi";
}
@GetMapping("/hien-thi")
	public String showSV(ModelMap m) {
	m.addAttribute("ds",dsSinhVien);
	return "show1";
}
}
