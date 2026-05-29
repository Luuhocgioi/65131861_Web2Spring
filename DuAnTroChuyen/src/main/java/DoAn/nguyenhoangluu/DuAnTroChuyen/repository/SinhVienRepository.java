package DoAn.nguyenhoangluu.DuAnTroChuyen.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.SinhVien;
public interface SinhVienRepository
extends JpaRepository<SinhVien, String> {

SinhVien findByMssvAndPassword(
    String mssv,
    String passwordS
    
);
SinhVien findByMssv(String mssv);
}
