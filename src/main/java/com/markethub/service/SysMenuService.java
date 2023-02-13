package com.markethub.service;

import com.markethub.common.dto.SysMenuDto;
import com.markethub.entity.SysMenu;
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
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuDto> getCurrentUserNav();

    List<SysMenu> tree();

}
