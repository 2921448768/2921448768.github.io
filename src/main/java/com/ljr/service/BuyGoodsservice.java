package com.ljr.service;

import com.ljr.domain.Sale;

public interface BuyGoodsservice {
    void buy(Integer GoodsItemId,Integer quantity) ;
    Sale buydetailed();
}
