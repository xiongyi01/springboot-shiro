package com.lx.springboot.service.impl;

import com.lx.springboot.entity.SysUser;
import com.lx.springboot.mapper.SysUserMapper;
import com.lx.springboot.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiongyi
 * @since 2019-02-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser getSysUserByUserName(String username) {
        return baseMapper.getSysUserByUserName(username);
    }
}
