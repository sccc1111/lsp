package com.lsp.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by songbo on 2018/8/6.
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired @Qualifier("defaultKaptcha")
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/captchaImage")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        response.setHeader("Pragma", "no-cache");

        response.setContentType("image/jpeg");

        String capText = defaultKaptcha.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = defaultKaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
    }
}
