package com.haha.mvcDemo.controller;

import com.haha.mvcDemo.common.BizException;
import com.haha.mvcDemo.common.JsonResponse;
import com.haha.mvcDemo.common.JsonResponseWrapper;
import com.haha.mvcDemo.common.SystemException;
import com.haha.mvcDemo.service.MallService;
import com.haha.mvcDemo.vo.CommodityVo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commodity")
public class CommodityController {

    @Autowired
    private MallService mallService;

    @ResponseBody
    @RequestMapping("{id}")
    private JsonResponse getCommodity(@PathVariable("id")int id){
        JsonResponse jsonResponse = new JsonResponse();
        CommodityVo commodityVo = mallService.findCommodityById(id);
        if (null==commodityVo){
            return JsonResponseWrapper.wrapBizException(new BizException("没有此商品！"));
        }
        return JsonResponseWrapper.wrapBizSuccess(commodityVo,"查询商品成功！");
    }

    @RequestMapping("select")
    private JsonResponse getCommodity(@RequestParam("name")String name){
        JsonResponse jsonResponse = new JsonResponse();
        List<CommodityVo> commodityVos = mallService.findCommodityByName(name);
        return JsonResponseWrapper.wrapBizSuccess(commodityVos,"查询商品成功！");
    }
}
