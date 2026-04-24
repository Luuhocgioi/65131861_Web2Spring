package thigk2.nguyenhoangluu.qlsanpham.models;

import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.nguyenhoangluu.qlsanpham.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}