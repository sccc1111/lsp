package com.lsp.core.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Name;
import java.util.Properties;

/**
 * Created by songbo on 2018/8/6.
 */
@Configuration
public class CaptchaConfig {
        @Bean(name="defaultKaptcha")
        public DefaultKaptcha getDefaultKaptcha(){
            DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
            Properties properties = new Properties();
            properties.setProperty("kaptcha.border", "yes");
            properties.setProperty("kaptcha.border.color", "105,179,90");
            properties.setProperty("kaptcha.textproducer.font.color", "blue");
            properties.setProperty("kaptcha.image.width", "100");
            properties.setProperty("kaptcha.image.height", "60");
            properties.setProperty("kaptcha.textproducer.font.size", "30");
            properties.setProperty("kaptcha.session.key", "kaptchaCode");
            properties.setProperty("kaptcha.textproducer.char.space", "5");
            properties.setProperty("kaptcha.textproducer.char.length", "4");
            properties.setProperty("kaptcha.textproducer.char.string", "ABCDE2345678GFDNMPWX");
            properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
            properties.setProperty("kaptcha.noise.color", "white");
            Config config = new Config(properties);
            defaultKaptcha.setConfig(config);
            return defaultKaptcha;
        }

    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getKaptchaBeanMath()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "160");
        properties.setProperty("kaptcha.image.height", "60");
        properties.setProperty("kaptcha.textproducer.font.size", "42");
        properties.setProperty("kaptcha.session.key", "kaptchaCodeMath");
        properties.setProperty("kaptcha.textproducer.impl", "com.ruoyi.framework.config.KaptchaTextCreator");
        properties.setProperty("kaptcha.textproducer.char.spac", "5");
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        properties.setProperty("kaptcha.textproducer.font.names", "Arial,Courier");
        properties.setProperty("kaptcha.noise.color", "white");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
