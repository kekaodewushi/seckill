package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by zangyaoyi on 2017/9/4.
 * 三个方面：方法定义粒度，参数，返回类型
 */
public interface SeckillService {
    /**
     *秒杀列表
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     *单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     *秒杀开始时输出秒杀接口地址，否则输出开始时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillCloseException,RepeatKillException,SeckillException;

    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillCloseException,RepeatKillException,SeckillException;
}
