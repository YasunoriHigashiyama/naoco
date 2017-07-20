/** test02.sql */
INSERT INTO HOGE_TABLE(COLUMN1, COLUMN2, COLUMN3) -- INSERT句
    SELECT                                        -- SELECT句
        COLUMN1, COLUMN2, COLUMN3
    FROM
        HAGE_TABLE
    WHERE
        COLUMN1 BETWEEN #column1_from# AND #column1_to#
