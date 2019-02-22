package com.lx.springboot.mapper;

import com.lx.springboot.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 通过用户信心查询权限信息
     * @param userId
     * @return
     */
    List<SysPermission> getSysPermissionByUserId(Integer userId);

}
