SELECT * FROM (
SELECT a.CAR_ID, a.CAR_TYPE, DAILY_FEE * 30 * (1-(DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR a 
, CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
WHERE NOT EXISTS (
                    SELECT 1
                      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY b 
                     WHERE  b.CAR_ID = a.CAR_ID
                       AND ((TO_DATE('20221130','YYYYMMDD') BETWEEN b.START_DATE AND b.END_DATE) 
                        OR (TO_DATE('20221101','YYYYMMDD') BETWEEN b.START_DATE AND b.END_DATE))
)
AND a.CAR_TYPE IN ('세단', 'SUV')
AND c.CAR_TYPE = a.CAR_TYPE
AND c.DURATION_TYPE = '30일 이상'
)
WHERE FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC