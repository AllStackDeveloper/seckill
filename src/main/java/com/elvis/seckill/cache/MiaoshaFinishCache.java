package com.elvis.seckill.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * 秒杀结束缓存
 * 
 * @category 秒杀结束缓存
 * @author elvis
 * @since 2019年12月22日
 */
@Component
public class MiaoshaFinishCache
{
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 设定是否秒杀结束
	 * 
	 * @category @author elvis
	 * @since 2019年12月22日 下午10:26:27
	 * @param goodsRandomName
	 */
	public void setFinish(String goodsRandomName)
	{
		redisUtil.set(getKey(goodsRandomName), "");
	}

	/**
	 * 指定商品秒杀是否结束
	 * 
	 * @category 指定商品秒杀是否结束
	 * @author elvis
	 * @since 2019年12月22日 下午10:31:01
	 * @param goodsRandomName
	 * @return
	 */
	public boolean isFinish(String goodsRandomName)
	{
		return redisUtil.get(getKey(goodsRandomName), String.class) != null;
	}

	private String getKey(String goodsRandomName)
	{
		String key = MessageFormat.format(CommonConstant.RedisKey.MIAOSHA_FINISH_FLAG,
				new Object[] { goodsRandomName });
		return key;
	}
}
