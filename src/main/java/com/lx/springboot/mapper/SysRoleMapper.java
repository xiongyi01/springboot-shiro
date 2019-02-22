package com.lx.springboot.mapper;

import com.lx.springboot.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 通过用户id查询角色信息
     * @param userId
     * @return
     */
    List<SysRole> getSysRoleByUserId(Integer userId);

}
