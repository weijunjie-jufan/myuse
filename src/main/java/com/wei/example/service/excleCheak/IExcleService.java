package com.wei.example.service.excleCheak;

import com.wei.example.bean.excleBean.ExcleSheet;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 魏俊杰
 * @CreateDate: 2018/5/3 11:37
 * @UpdateUser: 魏俊杰
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 */
public interface IExcleService {
    public List<ExcleSheet> findAllUrl();
    public ExcleSheet findOne(int i);
}
