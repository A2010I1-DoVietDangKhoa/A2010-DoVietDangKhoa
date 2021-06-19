package controller;


import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;

@Controller
@RequestMapping(value = {"product",""}, name = "productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public ModelAndView showHomePage(){
        return new ModelAndView("list", "listProduct", productService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreatePage(Model model){
        Product product = new Product();
        model.addAttribute(product);
        return "create";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("listProduct",productService.findAll());
        return "redirect:/";
    }

    @PostMapping(value = "/create")
    public String addNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.addNew(product);
        redirectAttributes.addFlashAttribute("listProduct",productService.findAll());
        return "redirect:/";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateProduct(@PathVariable int id, @ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.updateProduct(id, product);
        redirectAttributes.addFlashAttribute("listProduct",productService.findAll());
        return "redirect:/";
    }
}
