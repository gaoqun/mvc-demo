package com.haha.mvcDemo.controller;

import com.haha.mvcDemo.common.BizException;
import com.haha.mvcDemo.common.JsonResponse;
import com.haha.mvcDemo.common.JsonResponseWrapper;
import com.haha.mvcDemo.service.UserService;
import com.haha.mvcDemo.service.UserType;
import com.haha.mvcDemo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by gaige on 2018/1/19.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/{type}/{id}")
    public JsonResponse getUserInfo(@PathVariable("id") String userId, @PathVariable("type") UserType type) {
        UserVo userVo = null;
        switch (type) {
            case PhoneUser:
                userVo = userService.getWeChatUserById(UserType.PhoneUser, userId);
                break;
            case WeChatUser:
                userVo = userService.getWeChatUserById(UserType.WeChatUser, userId);
                break;
        }
        if (null == userVo) {
            return JsonResponseWrapper.wrapBizException(new BizException("无此用户！"));
        } else {
            return JsonResponseWrapper.wrapBizSuccess(userVo, "查询成功！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public JsonResponse addUser(@RequestParam("type")UserType userType) {
        UserVo userVo = new UserVo();
        userVo.setNickName("gaige");
        userVo.setUserName("高群");
        userVo.setTelephone("17600228859");
        userVo.setMoney(BigDecimal.valueOf(888.88));
        int id = userService.addUser(userType, userVo);
        if (0 < id) {
            return JsonResponseWrapper.wrapBizSuccess(null, "添加用户成功！");
        } else {
            BizException bizException = null;
            switch (id) {
                case -1:
                    bizException = new BizException("添加用户失败！");
                    break;
            }
            return JsonResponseWrapper.wrapBizException(bizException);
        }
    }

    @ResponseBody
    @RequestMapping(value = "combine",method = RequestMethod.GET)
    public JsonResponse combine(){
        UserVo userVo = userService.login(1);
        if (null==userVo){
            return JsonResponseWrapper.wrapBizException(new BizException("用户在合并啦。。。"));
        }else {
            return JsonResponseWrapper.wrapBizSuccess(userVo,"查询用户成功！");
        }
    }





}
