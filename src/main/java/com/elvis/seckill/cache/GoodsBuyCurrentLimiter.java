package com.elvis.seckill.cache;

import com.elvis.seckill.cache.base.CurrentLimiter;
import com.elvis.seckill.constant.CommonConstant;
import com.elvis.seckill.constant.MessageType;
import com.elvis.seckill.dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wang.moshu.message.MessageMonitor;

import java.text.MessageFormat;

/**
 * 商品购买限流器
 * 
 * @category 商品购买限流器
 * @author xiangyong.ding@weimob.com
 * @since 2017年3月16日 下午1:54:05
 */
@Component
public class GoodsBuyCurrentLimiter extends CurrentLimiter<String>
{
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private MessageMonitor messageMonitor;

	@Override
	protected String getLimiterName(String goodsRandomName)
	{
		String key = MessageFormat.format(CommonConstant.RedisKey.GOODS_STORE_BY_ID, new Object[] { goodsRandomName });
		return key;
	}

	@Override
	protected int getLimit(String goodsRandomName)
	{
		return goodsMapper.selectByRandomName(goodsRandomName).getStore()
				* CommonConstant.CurrentLimitMultiple.GOODS_BUY;
	}

	@Override
	protected int getCurrentLimit()
	{
		return messageMonitor.getMessageLeft(MessageType.MIAOSHA_MESSAGE);
	}

}
