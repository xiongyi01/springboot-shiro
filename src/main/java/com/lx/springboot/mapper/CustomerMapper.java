package com.lx.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lx.springboot.entity.Customer;

import java.util.List;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> getAllCustomer();



}
