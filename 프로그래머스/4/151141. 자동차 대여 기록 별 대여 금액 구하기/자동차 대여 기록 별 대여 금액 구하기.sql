--조건1 : 자동차 종류가 트럭
--조건2 : 대여기간에 해당하는 FEE 출력
SELECT B.HISTORY_ID                    AS HISTORY_ID
     , A.DAILY_FEE * B.PERIOD * NVL((SELECT 1 - (DISCOUNT_RATE / 100)
                                       FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                      WHERE DURATION_TYPE = B.PERIOD_DURATION_TYPE
                                        AND CAR_TYPE = '트럭'),1)
                                       AS FEE
  FROM CAR_RENTAL_COMPANY_CAR A
     , (SELECT HISTORY_ID
             , CAR_ID
             , (END_DATE - START_DATE + 1) AS PERIOD
             , CASE WHEN (END_DATE - START_DATE + 1) >= 90 THEN '90일 이상'
                    WHEN (END_DATE - START_DATE + 1) >= 30 THEN '30일 이상'
                    WHEN (END_DATE - START_DATE + 1) >= 7  THEN '7일 이상'
                    ELSE ''
                END AS PERIOD_DURATION_TYPE
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
         WHERE 1=1
       ) B
 WHERE 1=1
   AND A.CAR_ID = B.CAR_ID
   AND A.CAR_TYPE = '트럭'
 ORDER
    BY FEE DESC
     , HISTORY_ID DESC
   