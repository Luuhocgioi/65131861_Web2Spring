package thigk2.nguyenhoangluu.qlsanpham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thigk2.nguyenhoangluu.qlsanpham.entities.sanpham;
import thigk2.nguyenhoangluu.qlsanpham.entities.theloai;
import thigk2.nguyenhoangluu.qlsanpham.Repositories.SanPhamRepository;
import thigk2.nguyenhoangluu.qlsanpham.Repositories.TheLoaiRepository;

import java.util.List;

@RestController
@RequestMapping("/api") 
public class ApiController {

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;
    //http://localhost:8080/api/theloai
    @GetMapping("/theloai")
    public List<theloai> layDanhSachTheLoai() {
        return theLoaiRepository.findAll();
    }

    //http://localhost:8080/api/theloai/1/sanpham (Lấy sản phẩm của thể loại có ID = 1)
    @GetMapping("/theloai/{id}/sanpham")
    public List<sanpham> laySanPhamTheoTheLoai(@PathVariable("id") Long id) {
        return sanPhamRepository.findByCategoryId(id);
    }
}