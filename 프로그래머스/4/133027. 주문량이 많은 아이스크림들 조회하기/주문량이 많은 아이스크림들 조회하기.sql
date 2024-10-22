SELECT ICE_CREAM.FLAVOR
  FROM (
        SELECT A.FLAVOR
             , A.TOTAL_ORDER + B.JULY_TOTAL_ORDER AS TOTAL_ORDER
          FROM FIRST_HALF A
             , (SELECT FLAVOR           AS FLAVOR
                     , SUM(TOTAL_ORDER) AS JULY_TOTAL_ORDER
                  FROM JULY
                 GROUP
                    BY FLAVOR
               ) B
         WHERE 1=1
           AND A.FLAVOR = B.FLAVOR
         ORDER 
            BY TOTAL_ORDER DESC
       ) ICE_CREAM
 WHERE ROWNUM <= 3