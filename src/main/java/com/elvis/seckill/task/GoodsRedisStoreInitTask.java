package com.elvis.seckill.task;

import com.elvis.seckill.cache.GoodsRedisStoreCache;
import com.elvis.seckill.dao.GoodsMapper;
import com.elvis.seckill.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品redis库存初始化任务
 * 
 * @category @author xiangyong.ding@weimob.com
 * @since 2017年4月9日 上午11:47:50
 */
@Component
public class GoodsRedisStoreInitTask
{
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodsRedisStoreCache goodsRedisStore;

	/**
	 * 每隔1分钟触发一次
	 */
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void doInit()
	{
		List<Goods> goods = goodsMapper.selectAll();
		for (Goods item : goods)
		{
			goodsRedisStore.doInit(item);

		}
	}

}
