package thigk2.nguyenhoangluu.qlsanpham.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyenhoangluu.qlsanpham.entities.nguoidung;

public interface NguoiDungRepositories extends JpaRepository<nguoidung, Long> {
    Optional<nguoidung> findByUsername(String username);
}
