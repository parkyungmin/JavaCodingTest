SELECT A.MEMBER_NAME                        AS MEMBER_NAME
     , B.REVIEW_TEXT                        AS REVIEW_TEXT
     , TO_CHAR(B.REVIEW_DATE, 'YYYY-MM-DD') AS REVIEW_DATE
  FROM MEMBER_PROFILE A
     , REST_REVIEW B
 WHERE 1=1
   AND A.MEMBER_ID = B.MEMBER_ID
   AND A.MEMBER_ID IN (SELECT MEMBER_ID
                          FROM (
                                SELECT MEMBER_ID AS MEMBER_ID
                                     , COUNT(*) AS MAX
                                     , DENSE_RANK() OVER (ORDER BY COUNT(*) DESC) DENSE_RANK 
                                  FROM REST_REVIEW
                                 GROUP 
                                    BY MEMBER_ID
                                 ORDER
                                    BY MAX DESC
                               ) T
                         WHERE T.DENSE_RANK = 1
                      ) /* 리뷰를 가장 많이 작성한 MEMBER_ID를 가져온다. */
 ORDER
    BY B.REVIEW_DATE ASC
     , B.REVIEW_TEXT ASC