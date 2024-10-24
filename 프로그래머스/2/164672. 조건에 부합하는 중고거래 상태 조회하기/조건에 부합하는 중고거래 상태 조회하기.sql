SELECT A.BOARD_ID
     , A.WRITER_ID
     , A.TITLE
     , A.PRICE
     , DECODE(A.STATUS, 'DONE','거래완료','SALE','판매중','RESERVED','예약중') AS STATUS
  FROM USED_GOODS_BOARD A
 WHERE 1=1
   AND A.CREATED_DATE = TO_DATE('20221005','YYYYMMDD')
 ORDER
    BY A.BOARD_ID DESC