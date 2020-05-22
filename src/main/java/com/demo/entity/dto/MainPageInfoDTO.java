package com.demo.entity.dto;

import com.demo.entity.bo.HeadLine;
import com.demo.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
