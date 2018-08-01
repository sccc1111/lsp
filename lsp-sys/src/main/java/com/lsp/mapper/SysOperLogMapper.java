package com.lsp.mapper;

import com.lsp.entity.SysOperLog;
import org.springframework.stereotype.Component;

@Component(value = "sysOperLogMapper")
public interface SysOperLogMapper extends BaseMapper<SysOperLog,Integer> {
}