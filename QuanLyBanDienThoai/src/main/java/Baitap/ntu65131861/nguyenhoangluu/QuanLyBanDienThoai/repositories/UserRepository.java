package Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}