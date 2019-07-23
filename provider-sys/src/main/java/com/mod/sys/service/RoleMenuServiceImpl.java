package com.mod.sys.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mod.sys.dao.RoleMenuDao;
import com.mod.sys.entity.po.RoleMenuPO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.p
 * @since 2019-07-23
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao,RoleMenuPO> implements IRoleMenuService {

}
