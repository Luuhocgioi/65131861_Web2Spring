package thiGK.ntu._1.nguyenhoangluu_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;
import thiGK.ntu._1.nguyenhoangluu_fitCMS.repositories.PageRepository;

@RestController
public class ApiPageController_1 {
	// Để sử dụng Repos, ta Inject vào
	@Autowired
	PageRepository pRepos;
@GetMapping("restAPI/pages/all")
	public ArrayList<Page> getAllPage() {
	ArrayList<Page> dsTrang = new ArrayList<Page>();
	dsTrang.add(new Page(0,"ten Trang","Tu khoa","noi dung",0));
	dsTrang= (ArrayList<Page>) pRepos.findAll();
	return dsTrang;
}
}
