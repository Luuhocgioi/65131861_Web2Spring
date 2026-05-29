package DoAn.nguyenhoangluu.DuAnTroChuyen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DoAn.nguyenhoangluu.DuAnTroChuyen.entity.SinhVien;
import DoAn.nguyenhoangluu.DuAnTroChuyen.repository.SinhVienRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("mssv") String mssv,
            @RequestParam("password") String password,
            Model model,
            HttpSession session
    ) {

        SinhVien sv =
                sinhVienRepository.findByMssvAndPassword(
                        mssv,
                        password
                );

        if (sv != null) {

            session.setAttribute("user", sv);

            return "redirect:/home";
        }

        model.addAttribute(
                "error",
                "Sai MSSV hoặc password"
        );

        return "login";
    }
}