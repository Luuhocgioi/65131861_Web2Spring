package Baitap.ntu65131861.nguyenhoangluu.QuanLyBanHang.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanHang.Models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}