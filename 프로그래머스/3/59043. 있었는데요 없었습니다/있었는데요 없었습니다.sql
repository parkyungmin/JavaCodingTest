SELECT B.ANIMAL_ID
     , B.NAME
  FROM ANIMAL_INS A
     , ANIMAL_OUTS B
 WHERE A.ANIMAL_ID = B.ANIMAL_ID
   AND A.DATETIME > B.DATETIME
 ORDER
    BY A.DATETIME ASC