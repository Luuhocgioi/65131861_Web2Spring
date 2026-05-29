package DoAn.nguyenhoangluu.DuAnTroChuyen.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import DoAn.nguyenhoangluu.DuAnTroChuyen.dto.MessageDTO;
import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.ChatRoom;
import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.Message;
import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.SinhVien;
import DoAn.nguyenhoangluu.DuAnTroChuyen.repository.ChatRoomRepository;
import DoAn.nguyenhoangluu.DuAnTroChuyen.repository.MessageRepository;
import DoAn.nguyenhoangluu.DuAnTroChuyen.repository.SinhVienRepository;

@Controller
public class SocketChatController {

    @Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private MessageRepository messageRepository;
    @Autowired private ChatRoomRepository chatRoomRepository;
    @Autowired private SinhVienRepository sinhVienRepository;

    @MessageMapping("/sendMessage")
    public void sendMessage(MessageDTO dto) {

        SinhVien sv = sinhVienRepository.findById(dto.getNguoiGui()).orElse(null);
        ChatRoom room = chatRoomRepository.findById(dto.getRoomId()).orElse(null);

        // Chỉ lưu DB nếu là tin nhắn TEXT (file đã lưu ở /upload rồi)
        if (dto.getFileUrl() == null) {
            Message message = new Message();
            message.setNguoiGui(sv);
            message.setRoom(room);
            message.setThoiGian(LocalDateTime.now());
            message.setNoiDung(dto.getNoiDung());
            messageRepository.save(message);
        }

        dto.setNguoiGui(sv != null ? sv.getHoTen() : dto.getNguoiGui());
        messagingTemplate.convertAndSend("/topic/room/" + dto.getRoomId(), dto);
    }
}