package thigk2.nguyenhoangluu.qlsanpham.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Nhớ đảm bảo đúng đường dẫn package của bạn
import thigk2.nguyenhoangluu.qlsanpham.models.User; 
import thigk2.nguyenhoangluu.qlsanpham.Repositories.NguoiDungRepositories;
import thigk2.nguyenhoangluu.qlsanpham.entities.nguoidung;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private NguoiDungRepositories nguoiDungRepository; // Đổi tên biến cho khớp với kiểu dữ liệu

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm user trong DB
        nguoidung user = nguoiDungRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + username));
        
        // Trả về đối tượng UserDetails cho Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}