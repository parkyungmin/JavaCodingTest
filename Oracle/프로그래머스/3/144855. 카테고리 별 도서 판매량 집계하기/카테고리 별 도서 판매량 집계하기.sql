SELECT A.CATEGORY      AS CATEGORY
     , SUM(B.SALES)    AS TOTAL_SALES
  FROM BOOK A
     , BOOK_SALES B
 WHERE A.BOOK_ID = B.BOOK_ID
   AND B.SALES_DATE BETWEEN TO_DATE('20220101','YYYYMMDD') AND TO_DATE('20220131','YYYYMMDD')
 GROUP 
    BY A.CATEGORY
 ORDER
    BY A.CATEGORY