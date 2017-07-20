/**
 * CommonDAOTest01#test18 SQL File
 */
UPDATE
    TEST_TABLE
SET
    UTIL_DATE_VALUE = #date_value#,
    SQL_TIMESTAMP_VALUE = #date_value#,
    SQL_DATE_VALUE = #date_value#
WHERE
    STRING_ID = #string_id#
AND
    LONG_ID = #long_id#
AND
    DOUBLE_ID = #double_id#
