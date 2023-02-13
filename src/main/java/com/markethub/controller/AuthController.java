package com.markethub.controller;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.code.kaptcha.Producer;
import com.markethub.common.lang.Const;
import com.markethub.common.lang.Result;
import com.markethub.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

/**
 * @author Peter Huang
 * @date 2023/2/7 13:10
 **/
@RestController
public class AuthController extends BaseController {

    //引入验证码控制类
    @Autowired
    Producer producer;

    @GetMapping("/captcha")
    public Result captha() throws IOException {
        //生成32为随机验证码
        String key = UUID.randomUUID().toString();
        String code = producer.createText();

        key = "aaaaa";
        code = "11111";

        //将随机的code转换为验证码图片，将图片写进流
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";

        String base64Img = str + encoder.encode(outputStream.toByteArray());

        //将Key存储在redis中
        redisUtil.hset(Const.CAPTCHA_KEY, key, code, 120);

        return Result.succ(
                MapUtil.builder()
                        .put("token", key)
                        .put("captchaImg", base64Img)
                        .build()

        );

    }

    /**
     * 获取用户信息接口
     * @param principal
     * @return
     */
    @GetMapping("/sys/userInfo")
    public Result userInfo(Principal principal) {

        SysUser sysUser = sysUserService.getByUsername(principal.getName());

        return Result.succ(MapUtil.builder()
                .put("id", sysUser.getId())
                .put("username", sysUser.getUsername())
                .put("avatar", sysUser.getAvatar())
                .put("created", sysUser.getCreated())
                .map()
        );
    }



}
