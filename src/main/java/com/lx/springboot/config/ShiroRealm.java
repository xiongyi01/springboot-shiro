package com.lx.springboot.config;

import com.lx.springboot.entity.SysPermission;
import com.lx.springboot.entity.SysRole;
import com.lx.springboot.entity.SysUser;
import com.lx.springboot.service.SysPermissionService;
import com.lx.springboot.service.SysRoleService;
import com.lx.springboot.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author xiongyi
 * @Date 2019/2/21 14:58
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //获取登录后的用户主体信息//通过用户id查询用户的角色信息
        SysUser sysUser = (SysUser) principal.getPrimaryPrincipal();
        //通过用户id查询用户的角色信息
        List<SysRole> sysRoles = sysRoleService.getSysRoleByUserId(sysUser.getId());
        //获取角色的角色名称
        Set<String> roles = sysRoles.stream().map(SysRole::getRole).collect(Collectors.toSet());
        //把角色名称添加到用户授权中区
         authorizationInfo.setRoles(roles);
         //根据用户id查询权限信息
        List<SysPermission> sysPermissions = sysPermissionService.getSysPermissionByUserId(sysUser.getId());
        //获取权限的权限名称
        Set<String> permissions = sysPermissions.stream().map(SysPermission::getPermission).collect(Collectors.toSet());
        //把权限名称添加到用户授权中区
        authorizationInfo.setStringPermissions(permissions);
        //返回结果
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //前端获取用户名
        String username = (String)token.getPrincipal();
        //通过用户名查询数据库中的数据
        SysUser sysUser = sysUserService.getSysUserByUserName(username);
        //判断用户名是否存在
        if (Objects.isNull(sysUser)){
            //用户名不在时抛出异常
            throw new UnknownAccountException();
        }
        //判断用户的状态,如果状态不对抛出对应的异常
        if (Objects.equals("2",sysUser.getStatus())||Objects.equals("3",sysUser.getStatus())){
            throw  new DisabledAccountException();
        }
        //数据库中的数据的进行验证
        return new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),getName());
    }
}
