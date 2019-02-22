package com.lx.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lx.springboot.entity.SysPermission;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 通过用户信心查询权限信息
     * @param userId
     * @return
     */
    List<SysPermission> getSysPermissionByUserId(Integer userId);

}
