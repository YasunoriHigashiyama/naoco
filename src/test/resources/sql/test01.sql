/*
 test01.sqlT
 */
SELECT
  /*+ HINT HINT */
  a.COLUMN1, -- カラム1
  a.COLUMN2, -- カラム2
  a.COLUMN3  -- カラム3
FROM
--+ HINT2!
  TABLE_NAME a
WHERE
  a.COLUMN1=#value1#
  AND a.COLUMN2=#value2#
-- IF #isValueList3#
  AND a.COLUMN3 IN #valueList3#
-- ELSE #isValueList3#
  AND a.COLUMN3=#value3#
  AND b.COLUMN1 is not NULL
  AND b.COLUMN2 IN #value4#
-- ENDIF #isValueList3#
  AND a.COLUMN4 is NULL
/*
 * last comment
 * aaaa
 */
