package com.lx.springboot.mapper;

import com.lx.springboot.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getSysUserByUserName(String username);

}
