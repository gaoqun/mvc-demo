package com.haha.mvcDemo.service;

import com.haha.mvcDemo.domain.Commodity;
import com.haha.mvcDemo.vo.CommodityVo;

import java.util.List;

public interface MallService {

    //添加商品
    void addCommodity(Commodity commodity);

    //根据Id删除商品
    void deleteCommodityById(int id);

    //根据名字删除商品
    void deleteCommodityById(String name);

    //根据Id更改商品
    void updateCommodity(Commodity commodity);

    //根据id查询商品
    CommodityVo findCommodityById(int id);

    //根据名称查询商品
    List<CommodityVo> findCommodityByName(String name);


}
