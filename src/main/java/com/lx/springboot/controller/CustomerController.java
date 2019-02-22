package com.lx.springboot.controller;


import com.lx.springboot.entity.Customer;
import com.lx.springboot.service.CustomerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    @RequiresPermissions("customer:list")
    public String getCustomer(Model model){
        List<Customer> customers = customerService.getAllCustomer();
        model.addAttribute("customers",customers);
        return "customer";
    }

    @RequestMapping("/remove")
    @RequiresPermissions("customer:delete")
    public String removeById(int id){
        customerService.removeById(id);
        return "redirect:/customer";

    }

    @RequestMapping("/edit")
    @RequiresPermissions("customer:update")
    public String editById(Customer customer){
        System.out.println("aa");
        System.out.println(customer);
        boolean result = customerService.updateById(customer);
        System.out.println(result);
        return "redirect:/customer";
    }




}
