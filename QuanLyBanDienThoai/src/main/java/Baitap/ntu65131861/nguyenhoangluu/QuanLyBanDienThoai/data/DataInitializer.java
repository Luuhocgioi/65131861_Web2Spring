package Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.data;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.models.Role;
import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.models.User;
import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.repositories.RoleRepository;
import Baitap.ntu65131861.nguyenhoangluu.QuanLyBanDienThoai.repositories.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// Tạo role ROLE_USER nếu chưa có
		Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> {
			Role r = new Role();
			r.setName("ROLE_USER");
			return roleRepository.save(r);
		});

		// Tạo role ROLE_ADMIN nếu chưa có
		Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> {
			Role r = new Role();
			r.setName("ROLE_ADMIN");
			return roleRepository.save(r);
		});

		// Tạo user admin nếu chưa có
		if (userRepository.findByUsername("admin").isEmpty()) {
			User admin = new User();
			admin.setUsername("admin");
			// Mã hóa mật khẩu trước khi lưu vào database
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setEnabled(true);
			// Cấp cả 2 quyền cho tài khoản admin
			admin.setRoles(Set.of(adminRole, userRole));
			userRepository.save(admin);
		}
	}
}