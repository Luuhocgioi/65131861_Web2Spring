package Baitap.ntu65131861.nguyenhoangluu.QuanLyBanHang.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanHang.Models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
