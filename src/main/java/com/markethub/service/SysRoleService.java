package com.markethub.service;

import com.markethub.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 3 2 6 studio
 * @since 2023-02-06
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> listRolesByUserId(Long userId);

}
