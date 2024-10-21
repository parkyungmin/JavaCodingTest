SELECT CAR.*
  FROM (
        SELECT A.CAR_ID
             , A.CAR_TYPE
             , ROUND(30 * daily_fee * (1 - discount_rate / 100)) AS FEE
          FROM CAR_RENTAL_COMPANY_CAR A
             , CAR_RENTAL_COMPANY_DISCOUNT_PLAN C
         WHERE 1=1
           AND A.CAR_TYPE = C.CAR_TYPE
           AND C.DURATION_TYPE = '30일 이상'
           AND A.CAR_TYPE IN ('SUV', '세단')
           AND NOT EXISTS (SELECT 1
                             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                            WHERE CAR_ID = A.CAR_ID
                              AND ((TO_DATE('20221130','YYYYMMDD') BETWEEN START_DATE AND END_DATE) 
                               OR (TO_DATE('20221101','YYYYMMDD') BETWEEN START_DATE AND END_DATE))
                          )
      ) CAR
 WHERE CAR.FEE >= 500000
   AND CAR.FEE < 2000000
 ORDER 
    BY FEE DESC
     , car_type
     , car_id DESC