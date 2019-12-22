package com.elvis.seckill.cache.model;

import lombok.Data;

/**
 * 秒杀成功token（用来下单做验证）
 * 
 * @category 秒杀成功token
 * @author xiangyong.ding@weimob.com
 * @since 2017年4月9日 下午12:25:32
 */
@Data
public class MiaoshaSuccessToken
{
	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 商品ID
	 */
	private Integer goodsId;

	/**
	 * 成功占redis库存时间
	 */
	private long time;

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("MiaoshaSuccessToken [mobile=");
		builder.append(mobile);
		builder.append(", goodsId=");
		builder.append(goodsId);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}

}
