package com.lsp.service;

import com.lsp.entity.SysCron;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
public interface CronService {

    List<SysCron> selectAll();
}
