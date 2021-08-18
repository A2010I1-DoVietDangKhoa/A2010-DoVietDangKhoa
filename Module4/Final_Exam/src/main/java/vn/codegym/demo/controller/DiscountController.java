package vn.codegym.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.demo.model.DiscountEntity;
import vn.codegym.demo.service.DiscountService;

import java.util.Optional;

@Controller
@RequestMapping("/discounts")
public class DiscountController {
    private final DiscountService discountService;

    @Autowired
    private DiscountController(DiscountService discountService){
        this.discountService = discountService;
    }



    @GetMapping(value = "")
    public String getList(@RequestParam Optional<String> keyword, @PageableDefault(value = 4) Pageable pageable, Model model){
        Page<DiscountEntity> discountEntities;
        if (keyword.isPresent() && !keyword.get().toString().trim().equals("")) {
            model.addAttribute("keyword", keyword.get());

            discountEntities = discountService.getListWithParam(Integer.parseInt(keyword.get()), pageable);
        } else {
            discountEntities = discountService.getList(pageable);
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", discountEntities);
        return "discount/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("discount", new DiscountEntity());
        return "discount/create";
    }

    @PostMapping(value = "/create")
    public String addNew(RedirectAttributes redirectAttributes,
                         @Validated @ModelAttribute("discount") DiscountEntity discountEntity,
                         BindingResult bindingResult, Model model){
        new DiscountEntity().validate(discountEntity, bindingResult);
        if (bindingResult.hasErrors()){
            return "discount/create";
        }
        else {
            discountService.addNew(discountEntity);
            redirectAttributes.addFlashAttribute("message", "Created successfully!");
            return "redirect:/discounts";
        }
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model){
        model.addAttribute("discount", discountService.getOne(id));
        return "discount/update";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute("discount") DiscountEntity discountEntity,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        new DiscountEntity().validate(discountEntity, bindingResult);
        if (bindingResult.hasErrors()){
            return "discount/create";
        }
        else {
            discountService.addNew(discountEntity);
            redirectAttributes.addFlashAttribute("message", "Updated successfully!");
            return "redirect:/discounts";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id){
        discountService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted successfully!");
        return "redirect:/discounts";
    }
}
