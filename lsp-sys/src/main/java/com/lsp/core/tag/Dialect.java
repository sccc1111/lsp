package com.lsp.core.tag;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/30.
 */
public class Dialect extends AbstractProcessorDialect {

    @Override
    public Set<IProcessor> getProcessors(String s) {
        LinkedHashSet<IProcessor> processors = new LinkedHashSet<IProcessor>();
        //添加自定义标签处理器，可添加多个
        processors.add(new DictTagProcessor(s));//添加我们定义的标签
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, s));
        return processors;
    }

    public Dialect() {
        super("tag", "phxl", StandardDialect.PROCESSOR_PRECEDENCE);
    }


}
