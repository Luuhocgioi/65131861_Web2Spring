package Baitap.ntu65131861.nguyenhoangluu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
@GetMapping("/")
public String nhap() {
	return "form";
}
@PostMapping("/")
public String tinh(
	@RequestParam("w") double w, @RequestParam("h") double h,ModelMap m) {
	
	double kq = w/(h*h);
	m.addAttribute("w",w);
	m.addAttribute("h",h);
	m.addAttribute("kq",String.format("%.2f", kq));
	return "kq";
}
}
