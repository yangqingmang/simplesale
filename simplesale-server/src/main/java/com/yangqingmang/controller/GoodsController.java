package com.yangqingmang.controller;

import com.yangqingmang.dto.Goods;
import com.yangqingmang.service.GoodsService;
import com.yangqingmang.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * $DESCRIPTION$
 *
 * @author yangqingmang
 * @version 1.0
 * @date Create in 2018/10/3 上午11:10
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("list")
    public Response listGoods() {
        List<Goods> result = goodsService.findAllGoods();
        Response res = new Response();
        res.setResult(result);
        return res;
    }

    @PostMapping("new")
    public Response createGoods(@RequestBody Goods goods) {
        goodsService.addNewGoods(goods);
        Response res = new Response();
        res.setResult(goods);
        return res;
    }

    @PostMapping("del/{id}")
    public Response deleteGoods(@PathVariable String id) {
        int count = goodsService.delete(id);
        Response res = new Response();
        if (count > 0) {
            return res;
        } else {
            res.setCode(-1);
            res.setMessage("删除失败");
            return res;
        }
    }
}
