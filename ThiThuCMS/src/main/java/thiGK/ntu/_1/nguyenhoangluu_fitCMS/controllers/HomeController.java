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
		dsTrang.add(new Page () );
		dsTrang.add(new Page () );
		dsTrang.add(new Page () );
	}
	@GetMapping("/page/all")
	public String getAllTrang(ModelMap m) {
		m.addAttribute("lstPages","dsTrang");
		
		return "allpage";
	}
	//Action
}