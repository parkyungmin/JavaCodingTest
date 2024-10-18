SELECT A.PRODUCT_CODE AS PRODUCT_CODE
     , A.PRICE * B.PRODUCT_SALES_AMOUNT AS SALES
  FROM PRODUCT A  /* 상품마스터 */
     , (SELECT PRODUCT_ID
             , SUM(SALES_AMOUNT) AS PRODUCT_SALES_AMOUNT
          FROM OFFLINE_SALE
         GROUP
            BY PRODUCT_ID
       ) B        /* 상품별 판매량 */
 WHERE 1=1
   AND A.PRODUCT_ID = B.PRODUCT_ID
 ORDER
    BY SALES DESC, PRODUCT_CODE ASC