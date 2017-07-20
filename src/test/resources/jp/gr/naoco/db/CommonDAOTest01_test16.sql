
SELECT
    /*+ HINT BODY */
    STRING_ID,
    LONG_ID,
    DOUBLE_ID,
    STRING_VALUE,
    UTIL_DATE_VALUE
FROM
    TEST_TABLE
WHERE
    STRING_ID = #string_id#
AND
    LONG_ID = #long_id#
AND
    DOUBLE_ID = #double_id#
AND
    UTIL_DATE_VALUE < #date_value#
-- IF #isSqlTimestamp#
AND
    SQL_TIMESTAMP_VALUE < #date_value#
-- ELSE #isSqlTimestamp#
AND
    SQL_DATE_VALUE < #date_value#
-- ENDIF #isSqlTimestamp#
ORDER BY
    STRING_ID, LONG_ID, DOUBLE_ID
/**
 * CommonDAOTest01#test16 SQL File
 */