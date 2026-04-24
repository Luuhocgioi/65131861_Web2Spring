package thigk2.nguyenhoangluu.qlsanpham.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyenhoangluu.qlsanpham.entities.sanpham;

public interface SanPhamRepository extends JpaRepository<sanpham, Long> {
    List<sanpham> findByCategoryId(Long categoryId); 
}