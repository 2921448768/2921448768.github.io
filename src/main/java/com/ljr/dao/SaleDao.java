package com.ljr.dao;

import com.ljr.domain.Sale;

public interface SaleDao {
    int insertSale(Sale sale) ;
    Sale selectSale(Integer id) ;
}
