package com.mod.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mod.user.dao.AccountDao;
import com.mod.user.entity.po.AccountPO;
import com.mod.user.service.IAccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountDao,AccountPO> implements IAccountService {

}
