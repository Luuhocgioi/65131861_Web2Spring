package thigk2.nguyenhoangluu.qlsanpham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import thigk2.nguyenhoangluu.qlsanpham.Repositories.SanPhamRepository;
import thigk2.nguyenhoangluu.qlsanpham.Repositories.TheLoaiRepository;
import thigk2.nguyenhoangluu.qlsanpham.entities.sanpham;

@Controller
public class WebController {

    @Autowired
    private SanPhamRepository productRepository;
    @Autowired
    private TheLoaiRepository categoryRepository;

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "products"; //
    }

    @GetMapping("/products/category/{categoryId}")
    public String showProductsByCategory(@PathVariable("categoryId") Long categoryId, Model model) {
        model.addAttribute("products", productRepository.findByCategoryId(categoryId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "products"; 
    }

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model) {
        sanpham product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "product-detail"; 
    }
}
