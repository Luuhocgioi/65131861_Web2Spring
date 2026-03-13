package Baitap.ntu65131861.nguyenhoangluu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
	@GetMapping("/") //http://localhost:8080/?Ten=NguyenHoangLuu&Tuoi=21
	public String XuatTT( @RequestParam("Ten") String ten, @RequestParam("Tuoi") String tuoi, ModelMap m) {
	m.addAttribute("ten",ten);
	m.addAttribute("tuoi",tuoi);
	return "index";
	}
	
}
