package Baitap.ntu65131861.nguyenhoangluu.DemoBaoMatCoBan.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "homepage";
	}
	// Test nguoi dung thong thuong
	@GetMapping("/products/*")
	public String index1() {
		return"sanpham";
	}
	//Test user admin
	@GetMapping("/admincp/*")
	public String index2() {
		return"indexAdmin";
	}
	@GetMapping("/hello/*")
	public String hi() {
		return"hello";
	}
}
