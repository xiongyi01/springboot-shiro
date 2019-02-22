package com.lx.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lx.springboot.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过用户id查询角色信息
     * @param userId
     * @return
     */
    List<SysRole> getSysRoleByUserId(Integer userId);


}
