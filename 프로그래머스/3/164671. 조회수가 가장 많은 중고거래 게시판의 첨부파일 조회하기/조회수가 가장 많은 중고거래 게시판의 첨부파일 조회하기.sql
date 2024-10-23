/*정답 풀이 1번*/
/*
SELECT '/home/grep/src/' || A.BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT AS FILE_PATH
  FROM USED_GOODS_BOARD A
     , USED_GOODS_FILE B
 WHERE A.BOARD_ID = B.BOARD_ID
   AND A.VIEWS = (SELECT MAX(VIEWS)
                    FROM USED_GOODS_BOARD
                 )
 ORDER
    BY B.FILE_ID DESC
*/

/*정답 풀이 2번 - RANK함수 사용*/
SELECT '/home/grep/src/' || A.BOARD_ID || '/' || B.FILE_ID || B.FILE_NAME || B.FILE_EXT AS FILE_PATH
  FROM (SELECT A.BOARD_ID
             , A.VIEWS
             , DENSE_RANK() OVER(ORDER BY A.VIEWS DESC) AS RANK
          FROM USED_GOODS_BOARD A
       ) A
     , USED_GOODS_FILE B
 WHERE 1=1
   AND A.BOARD_ID = B.BOARD_ID
   AND A.RANK = 1
 ORDER
    BY B.FILE_ID DESC

 