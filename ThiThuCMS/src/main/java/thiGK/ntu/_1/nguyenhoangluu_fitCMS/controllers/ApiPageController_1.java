package thiGK.ntu._1.nguyenhoangluu_fitCMS.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;
import thiGK.ntu._1.nguyenhoangluu_fitCMS.repositories.PageRepository;
import thiGK.ntu._1.nguyenhoangluu_fitCMS.services.PageService;

@RestController
public class ApiPageController_1 {
	// Để sử dụng Repos, ta Inject vào
	@Autowired
	PageService pService;
@GetMapping("restAPI/pages/all")
	public List<Page> getAllPage() {
//	ArrayList<Page> dsTrang = new ArrayList<Page>();
//	dsTrang.add(new Page(0,"ten Trang","Tu khoa","noi dung",0));
//	dsTrang= (ArrayList<Page>) pRepos.findAll();
	List<Page> dsTrang = new ArrayList<Page>();
	dsTrang = pService.getAllPage();
	return dsTrang;
}
@GetMapping("restAPI/page/{id}")
public Page getPage(@PathVariable("id") int id) {
	return pService.getPageById(id);
}
}
