package vn.codegym.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.service.CustomerService;
import vn.codegym.casestudy.service.CustomerTypeService;

@Controller(value = "/customers")
@SessionAttributes("user")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerTypeService customerTypeService;

    @Autowired
    private CustomerController(CustomerService customerService,
                               CustomerTypeService customerTypeService){
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping(value = "/list")
    public String getList(@RequestParam String keyword, @PageableDefault(value = 4) Pageable pageable, Model model){
        Page<CustomerEntity> customers;
        if (keyword == null) {
            keyword = "";
        }
        model.addAttribute("key", keyword);
        customers = customerService.getList(keyword, pageable);
        model.addAttribute("list", customers);
        return "customers/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("types", customerTypeService.getList());
        return "customers/create";
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getOne(id));
        model.addAttribute("types", customerTypeService.getList());
        return "customers/update";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute("customer") CustomerEntity customerEntity,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model){
        new CustomerEntity().validate(customerEntity, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("types", customerTypeService.getList());
            return "customers/update";
        }
        else {
            customerService.update(customerEntity);
            redirectAttributes.addFlashAttribute("message", "Updated successfully!");
            return "redirect:";
        }
    }

    @PostMapping(value = "/create")
    public String addNew(RedirectAttributes redirectAttributes, @Validated @ModelAttribute("customer") CustomerEntity customerEntity,
                         BindingResult bindingResult, Model model){
        new CustomerEntity().validate(customerEntity, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("types", customerTypeService.getList());
            return "customers/create";
        }
        else {
            customerService.addNew(customerEntity);
            redirectAttributes.addFlashAttribute("message", "Created successfully!");
            return "redirect:";
        }
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable Integer id){
        customerService.delete(id);
        return "redirect:";
    }
}
