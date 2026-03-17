package Baitap.ntu65131861.nguyenhoangluu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SinhVienController {
@GetMapping("/")
	public String NhapTT(ModelMap m) {
	SinhVien sv = new SinhVien("","","","");
	m.addAttribute("sv",sv);
	return "nhapTT";
}
@PostMapping("/luuSV")
	public String LuuSV(@ModelAttribute("sv") SinhVien sv,RedirectAttributes ra) {
	ra.addFlashAttribute("sv", sv);
	return "redirect:/hien-thi";
}
@GetMapping("/hien-thi")
	public String showSV() {
	return "show1";
}
}
