package DoAn.nguyenhoangluu.DuAnTroChuyen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.Message;

public interface MessageRepository
        extends JpaRepository<Message, Long> {

    List<Message> findByRoomId(Long roomId);

}