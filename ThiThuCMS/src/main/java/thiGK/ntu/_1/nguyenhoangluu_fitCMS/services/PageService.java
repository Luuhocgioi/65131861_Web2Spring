package thiGK.ntu._1.nguyenhoangluu_fitCMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiGK.ntu._1.nguyenhoangluu_fitCMS.models.Page;
import thiGK.ntu._1.nguyenhoangluu_fitCMS.repositories.PageRepository;

@Service
public class PageService {
	// Dịch vụ lấy về tất cả các trang
	@Autowired
	PageRepository pRepos;
	public List<Page> getAllPage(){
		return pRepos.findAll();
	}
	public Page getPageById(int id) {
		return pRepos.getById(id);
	}
}
