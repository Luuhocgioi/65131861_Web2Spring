package Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.models.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
}