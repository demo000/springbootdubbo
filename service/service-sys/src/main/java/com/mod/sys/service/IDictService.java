package com.mod.sys.service;

import com.mod.sys.entity.dto.DictDTO;
import com.mod.sys.entity.po.DictPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.p
 * @since 2019-07-23
 */
public interface IDictService extends IService<DictPO> {

    /**
     * 插入或者更新
     * @param dto
     * @return
     */
    Long insertOrUpdate(DictDTO dto);
}
