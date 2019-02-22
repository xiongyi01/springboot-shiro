package com.lx.springboot.service;

import com.lx.springboot.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getSysUserByUserName(String username);

}
