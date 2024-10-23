SELECT A.REST_ID
     , A.REST_NAME
     , A.FOOD_TYPE
     , A.FAVORITES
     , A.ADDRESS
     , ROUND(B.AVG_REVIEW_SCORE,2) AS SCORE
  FROM REST_INFO A
     , (SELECT REST_ID
             , AVG(REVIEW_SCORE) AS AVG_REVIEW_SCORE
          FROM REST_REVIEW 
         GROUP
            BY REST_ID
       ) B
 WHERE 1=1
   AND A.REST_ID = B.REST_ID
   AND A.ADDRESS LIKE '서울%' -- SUBSTR 사용 : AND SUBSTR(A.ADDRESS,1,2) = '서울'
 ORDER
    BY SCORE DESC
     , FAVORITES DESC

   