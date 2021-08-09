package com.example.form_emp.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.form_emp.Model.Employee;
import com.example.form_emp.Service.IEmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/emp")
public class HomeController {
    @Autowired
    IEmpService empService;

    @GetMapping(value = "")
    public String getEmp(@RequestParam(required = false) String search, Model model) {
        List<Employee> listEmp = empService.findAll();
        model.addAttribute("search", search);
        if(search == null){
            model.addAttribute("list", listEmp);
        } else {
            List<Employee> listSearch = new ArrayList<>();
            search = search.toLowerCase();
            for (Employee emp : listEmp) {
                String email = emp.getEmailId().toLowerCase();
                String firstName = emp.getFirstName().toLowerCase();
                String lastName = emp.getLastName().toLowerCase();
                if(email.contains(search) || 
                firstName.contains(search) || 
                lastName.contains(search)) {
                    listSearch.add(emp);
                }
            }
            model.addAttribute("list", listSearch);
        }
        return "home";
    }

    @GetMapping(value = "/add")
    public String getAddForm(Model model) {
        model.addAttribute("title", "Add Employee");
        model.addAttribute("emp", new Employee());
        return "add_edit";
    }

    @PostMapping()
    public String createEmp(@ModelAttribute("emp") @Valid Employee newEmp, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (newEmp.getId() != null) {
                empService.update(newEmp.getId(), newEmp);
            } else {
                empService.add(newEmp);
            }
            return "redirect:emp";
        } else {
            return "add_edit";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Employee> empOpt = empService.findById(id);
        if (empOpt.isPresent()) {
            model.addAttribute("emp", empOpt.get());
            model.addAttribute("title", "Edit Employee");
        } 
        return "add_edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmp(@PathVariable("id") Long id, Model model) {
        empService.deleteById(id);
        return "redirect:/emp";
    }
    // @ExceptionHandler
    // public void exceptionHandler(){
        
    // }
}
