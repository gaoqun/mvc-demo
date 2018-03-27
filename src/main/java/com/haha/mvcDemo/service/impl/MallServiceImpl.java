package com.haha.mvcDemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.haha.mvcDemo.dao.CommodityDao;
import com.haha.mvcDemo.domain.Commodity;
import com.haha.mvcDemo.service.MallService;
import com.haha.mvcDemo.vo.CommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallServiceImpl implements MallService {

    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void addCommodity(Commodity commodity) {

    }

    @Override
    public void deleteCommodityById(int id) {

    }

    @Override
    public void deleteCommodityById(String name) {

    }

    @Override
    public void updateCommodity(Commodity commodity) {

    }

    @Override
    public CommodityVo findCommodityById(int id) {
        CommodityVo commodityVo = null;
        Commodity commodity1 = (Commodity) JSON.parse(redisTemplate.opsForValue().get("commodity_" + id));
        if (commodity1!=null){
            if (null != commodity1) {
                commodityVo = new CommodityVo();
                commodityVo.setTotalStock(commodity1.getTotalStock());
                commodityVo.setRemainStock(commodity1.getRemaindStock());
                commodityVo.setImg(commodity1.getImg());
                commodityVo.setId(commodity1.getId());
                commodityVo.setName(commodity1.getName());
                commodityVo.setType(commodity1.getType());
                commodityVo.setMemberPrice(commodity1.getMemberPrice());
                commodityVo.setOriginalPrice(commodity1.getOriginalPrice());
                commodityVo.setPrice(commodity1.getPrice());
            }
        }else {
            Commodity commodity = commodityDao.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set("commodity_" + id, JSON.toJSONString(commodity));
                commodityVo = new CommodityVo();
                commodityVo.setTotalStock(commodity1.getTotalStock());
                commodityVo.setRemainStock(commodity1.getRemaindStock());
                commodityVo.setImg(commodity1.getImg());
                commodityVo.setId(commodity1.getId());
                commodityVo.setName(commodity1.getName());
                commodityVo.setType(commodity1.getType());
                commodityVo.setMemberPrice(commodity1.getMemberPrice());
                commodityVo.setOriginalPrice(commodity1.getOriginalPrice());
                commodityVo.setPrice(commodity1.getPrice());
        }

        return commodityVo;
    }

    @Override
    public List<CommodityVo> findCommodityByName(String name) {
        List<Commodity> commodities = commodityDao.selectByName(name);
        List<CommodityVo> commodityVos = new ArrayList<>();
        if (commodities == null || commodities.isEmpty()) {
            return null;
        } else {
            for (Commodity commodity : commodities) {
                CommodityVo commodityVo = new CommodityVo();
                commodityVo.setTotalStock(commodity.getTotalStock());
                commodityVo.setRemainStock(commodity.getRemaindStock());
                commodityVo.setImg(commodity.getImg());
                commodityVo.setId(commodity.getId());
                commodityVo.setName(commodity.getName());
                commodityVo.setType(commodity.getType());
                commodityVo.setMemberPrice(commodity.getMemberPrice());
                commodityVo.setOriginalPrice(commodity.getOriginalPrice());
                commodityVo.setPrice(commodity.getPrice());
                commodityVos.add(commodityVo);
            }
        }
        return commodityVos;
    }
}
