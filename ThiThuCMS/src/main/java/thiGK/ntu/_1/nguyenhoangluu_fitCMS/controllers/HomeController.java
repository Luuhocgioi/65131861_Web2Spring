package thiGK.ntu._1.nguyenhoangluu_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;
import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Post;

@Controller

public class HomeController {
//	@GetMapping("/index")
//	public String home() {
//		return "index";
//	}
	//Danh sach page, post
	ArrayList<Page> dsTrang = new ArrayList<Page>();
	ArrayList<Post> dsBaiViet = new ArrayList<Post>();

	public HomeController(){
		dsTrang.add(new Page(1, "Giới thiệu", "intro, ntu", "Nội dung giới thiệu...", 0));
		dsTrang.add(new Page(2, "Liên hệ", "contact", "Thông tin liên hệ...", 1));
		dsTrang.add(new Page(3, "Chính sách", "Terms", "Chính sách của chúng tôi", 1));
	}
	@GetMapping("/page/all")
	public String getAllTrang(ModelMap m) {
		m.addAttribute("lstPages",dsTrang);
		
		return "allpage";
	}
	//Action
}