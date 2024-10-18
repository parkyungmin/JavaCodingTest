SELECT A.NAME
     , A.DATETIME
  FROM (
        SELECT I.NAME     AS NAME
             , I.DATETIME AS DATETIME
          FROM ANIMAL_INS I
             , ANIMAL_OUTS O
         WHERE 1=1
           AND I.ANIMAL_ID = O.ANIMAL_ID(+)
           AND O.animal_id IS NULL
         ORDER
            BY I.DATETIME ASC
       ) A
 WHERE 1=1
   AND ROWNUM <= 3