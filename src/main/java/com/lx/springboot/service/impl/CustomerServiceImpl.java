package com.lx.springboot.service.impl;

import com.lx.springboot.entity.Customer;
import com.lx.springboot.mapper.CustomerMapper;
import com.lx.springboot.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public List<Customer> getAllCustomer() {
        return baseMapper.getAllCustomer();
    }
}
