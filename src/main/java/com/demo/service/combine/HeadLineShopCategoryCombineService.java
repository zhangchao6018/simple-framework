package com.demo.service.combine;

import com.demo.entity.dto.MainPageInfoDTO;
import com.demo.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    /**
     * 获取首页信息
     * @return
     */
    Result<MainPageInfoDTO> getMainPageInfo();
}
