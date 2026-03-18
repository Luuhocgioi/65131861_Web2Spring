package thiGK.ntu._1.nguyenhoangluu_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;

@RestController
public class APIPageController {

	ArrayList<Page> dsTrang = new ArrayList<Page>();
	public APIPageController() {
		Page p1 = new Page(0,"Gioi thieu","mct","asdqwe",0);
		Page p2 = new Page(1,"Gioi thieu","mct","asdqwe",0);
		Page p3 = new Page(2,"Gioi thieu","mct","asdqwe",0);
		dsTrang.add(p1);
		dsTrang.add(p2);
		dsTrang.add(p3);
	}

@GetMapping("/api/pages")
public ArrayList<Page> getAllPages(){
	return dsTrang;
}
@GetMapping("/api/page/{id}")
public Page getOneOBJ(@PathVariable Long id) {
	for(Page p:dsTrang)
		if(p.getId()==id)
			return p;
	return null;
}

}