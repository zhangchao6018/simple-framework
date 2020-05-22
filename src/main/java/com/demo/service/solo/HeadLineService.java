package com.demo.service.solo;

import com.demo.entity.bo.HeadLine;
import com.demo.entity.dto.Result;

import java.util.List;

/**
 * 头条service层接口
 */
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>>queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
