package com.lsp.service.Impl;

import com.lsp.entity.SysCron;
import com.lsp.mapper.SysCronMapper;
import com.lsp.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songbo on 2018/8/2.
 */
@Service
public class CronServiceImpl implements CronService {

    @Autowired
    private SysCronMapper sysCronMapper;

    @Override
    public List<SysCron> selectAll() {
        return sysCronMapper.selectAll();
    }
}
