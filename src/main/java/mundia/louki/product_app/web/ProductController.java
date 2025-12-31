package mundia.louki.product_app.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mundia.louki.product_app.entities.Product;
import mundia.louki.product_app.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;

    @GetMapping(path = "/user/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Product> pageProducts = productRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listProducts", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "products";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page) {
        productRepository.deleteById(id);
        return "redirect:/user/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/admin/formProducts")
    public String formProducts(Model model) {
        model.addAttribute("product", new Product());
        return "formProducts";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Product product, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword) {
        if (bindingResult.hasErrors()) return "formProducts";
        productRepository.save(product);
        return "redirect:/user/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/admin/editProduct")
    public String editProduct(Model model, Long id, String keyword, int page) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) throw new RuntimeException("Produit introuvable");
        model.addAttribute("product", product);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editProduct";
    }
}