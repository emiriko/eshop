package cs.ui.ac.id.advprog.eshop.controller;

import cs.ui.ac.id.advprog.eshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String getProductPage(Model model) {
        return "home";
    }
}