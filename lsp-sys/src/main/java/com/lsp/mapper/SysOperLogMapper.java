package com.lsp.mapper;

import com.lsp.entity.SysOperLog;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

@Component(value = "sysOperLogMapper")
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
}