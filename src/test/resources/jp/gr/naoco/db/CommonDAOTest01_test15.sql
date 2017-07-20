/**
 * CommonDAOTest01#test15 SQL File
 */
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
-- IF #isUtilDate#
AND
    UTIL_DATE_VALUE < #date_value#
-- ENDIF #isUtilDate#
-- IF #isSqlTimestamp#
AND
    SQL_TIMESTAMP_VALUE < #date_value#
-- ELSE #isSqlTimestamp#
AND
    SQL_DATE_VALUE < #date_value#
-- ENDIF #isSqlTimestamp#
ORDER BY
    STRING_ID, LONG_ID, DOUBLE_ID