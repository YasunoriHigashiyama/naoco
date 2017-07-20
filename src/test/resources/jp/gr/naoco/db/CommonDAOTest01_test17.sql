SELECT

/**
 * CommonDAOTest01#test17 SQL File
 */
    COUNT(*)
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
-- ENDIF #isSqlTimestamp#
-- IF #isSqlDate#
AND
    SQL_DATE_VALUE < #date_value#
-- ENDIF #isSqlDate#
ORDER BY
    STRING_ID, LONG_ID, DOUBLE_ID