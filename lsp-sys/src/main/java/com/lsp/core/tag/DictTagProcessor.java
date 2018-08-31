package com.lsp.core.tag;

import com.lsp.entity.SysDictData;
import com.lsp.mapper.SysDictDataMapper;
import com.lsp.service.DictService;
import com.lsp.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */
public class DictTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME  = "dict";

    private static final int PRECEDENCE = 10000;//优先级

    @Autowired
    DictService dictService;
    public DictTagProcessor(TemplateMode templateMode, String dialectPrefix, String elementName, boolean prefixElementName, String attributeName, boolean prefixAttributeName, int precedence) {
        super(templateMode, dialectPrefix, elementName, prefixElementName, attributeName, prefixAttributeName, precedence);
    }

    public DictTagProcessor( String dialectPrefix) {
        super(
                TemplateMode.HTML, // 此处理器将仅应用于HTML模式
                dialectPrefix,     // 要应用于名称的匹配前缀
                TAG_NAME,          // 标签名称：匹配此名称的特定标签
                true,              // 将标签前缀应用于标签名称
                null,              // 无属性名称：将通过标签名称匹配
                false,             // 没有要应用于属性名称的前缀
                PRECEDENCE);       // 优先(内部方言自己的优先)


    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext, IProcessableElementTag tag, IElementTagStructureHandler iElementTagStructureHandler) {
        IAttribute id = tag.getAttribute("id");
        IAttribute name = tag.getAttribute("name");
        IAttribute Class = tag.getAttribute("class");
        IAttribute dictType = tag.getAttribute("dictType");

        //获取应用上下文
        ApplicationContext appCtx = SpringContextUtils.getApplicationContext(iTemplateContext);

        final IModelFactory modelFactory = iTemplateContext.getModelFactory();

        final IModel model = modelFactory.createModel();
        StringBuffer str =  new StringBuffer();
        str.append("<select ");
        if(null!=name&&StringUtils.isNotEmpty(name.getValue())){
            str.append(" name='"+name.getValue()+"'");
        }
        if(null!=id&&StringUtils.isNotEmpty(id.getValue())){
            str.append(" id='"+id.getValue()+"'");
        }
        if(null!=Class&&StringUtils.isNotEmpty(Class.getValue())){
            str.append(" class='"+Class+"'");
        }
        str.append("> ").append("<option value='' >请选择</option>");
        //字典类型
        if(null!=dictType&&StringUtils.isNotEmpty(dictType.getValue())){
            SysDictDataMapper mapper = appCtx.getBean(SysDictDataMapper.class);
            List<SysDictData> list = mapper.selectDictListByCode(dictType.getValue());
            for(int i=0;i<list.size();i++){
                str.append("<option value='"+list.get(i).getDictValue()+"' >"+list.get(i).getDictLabel()+"</option>");
            }
        }
        str.append("</select>");
        model.add(modelFactory.createText(str));

       /*
        * 指示引擎用指定的模型替换整个元素。
        */
        iElementTagStructureHandler.replaceWith(model, false);
    }
}
