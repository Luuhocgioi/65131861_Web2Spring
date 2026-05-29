package DoAn.nguyenhoangluu.DuAnTroChuyen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import DoAn.nguyenhoangluu.DuAnTroChuyen.dto.MessageDTO;
import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.*;
import DoAn.nguyenhoangluu.DuAnTroChuyen.repository.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

    @Autowired private ChatRoomRepository chatRoomRepository;
    @Autowired private MessageRepository messageRepository;

    // ── GET /room/{id} ─────────────────────────────────────
    @GetMapping("/room/{id}")
    public String room(@PathVariable("id") Long id, Model model, HttpSession session) {

        SinhVien sv = (SinhVien) session.getAttribute("user");
        if (sv == null) return "redirect:/login";

        ChatRoom room = chatRoomRepository.findById(id).orElse(null);
        if (room == null) return "redirect:/home";

        if (room.getKhoa() != null)
            if (!room.getKhoa().getMaKhoa().equals(sv.getKhoa().getMaKhoa()))
                return "redirect:/home";

        if (room.getLop() != null)
            if (!room.getLop().getMaLop().equals(sv.getLop().getMaLop()))
                return "redirect:/home";

        if ("PRIVATE".equals(room.getLoaiRoom())) {
            boolean ok = (room.getUser1() != null && room.getUser1().getMssv().equals(sv.getMssv()))
                      || (room.getUser2() != null && room.getUser2().getMssv().equals(sv.getMssv()));
            if (!ok) return "redirect:/home";
        }

        ChatRoom khoaRoom = chatRoomRepository
                .findByKhoaAndLoaiRoom(sv.getLop().getKhoa(), "KHOA")
                .orElse(null);
        ChatRoom lopRoom = chatRoomRepository
                .findByLopAndLoaiRoom(sv.getLop(), "LOP")
                .orElse(null);

        List<ChatRoom> rooms = new ArrayList<>();
        if (khoaRoom != null) rooms.add(khoaRoom);
        if (lopRoom  != null) rooms.add(lopRoom);

        model.addAttribute("sv", sv);
        model.addAttribute("room", room);
        model.addAttribute("rooms", rooms);
        model.addAttribute("privateRooms", chatRoomRepository.findPrivateRooms(sv));
        model.addAttribute("messages", messageRepository.findByRoomId(id));

        return "room";
    }

    // ── POST /room/{id}/upload — upload file, trả về JSON ──
    @PostMapping("/room/{id}/upload")
    @ResponseBody
    public ResponseEntity<MessageDTO> uploadFile(
            @PathVariable("id") Long id,
            @RequestParam("file") MultipartFile file,
            HttpSession session
    ) throws IOException {

        SinhVien sv = (SinhVien) session.getAttribute("user");
        if (sv == null) return ResponseEntity.status(401).build();

        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        file.transferTo(new File(uploadDir + fileName));

        String fileUrl  = "/uploads/" + fileName;
        String fileType = (file.getContentType() != null && file.getContentType().startsWith("image/"))
                          ? "IMAGE" : "FILE";

        // Lưu message vào DB
        ChatRoom room = chatRoomRepository.findById(id).orElse(null);
        Message message = new Message();
        message.setNguoiGui(sv);
        message.setRoom(room);
        message.setThoiGian(LocalDateTime.now());
        message.setFileName(file.getOriginalFilename());
        message.setFileUrl(fileUrl);
        message.setFileType(fileType);
        messageRepository.save(message);

        // Trả về DTO để JS gửi qua STOMP
        MessageDTO dto = new MessageDTO();
        dto.setRoomId(id);
        dto.setNguoiGui(sv.getMssv());
        dto.setFileName(file.getOriginalFilename());
        dto.setFileUrl(fileUrl);
        dto.setFileType(fileType);

        return ResponseEntity.ok(dto);
    }
}