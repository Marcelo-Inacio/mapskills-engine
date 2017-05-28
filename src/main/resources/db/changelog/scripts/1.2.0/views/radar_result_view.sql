-- radar_result_view.sql 1.2.0 29/04/2017
-- Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
-- Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.

DROP VIEW IF EXISTS RADAR_RESULT_VIEW;

CREATE VIEW RADAR_RESULT_VIEW AS
	SELECT SQE.USE_ID AS USER_ID,
        SKILL.SKI_TYPE AS SKILL_TYPE,
        SKILL.SKI_DESCRIPTION AS SKILL_DESCRIPTION,
        SUM(SQE.SQE_SKILL_VALUE) AS TOTAL
	FROM SKILL
	INNER JOIN STUDENT_QUESTION_EVENT SQE
	ON SQE.SKI_ID = SKILL.SKI_ID
	GROUP BY USER_ID, SKILL_TYPE, SKILL_DESCRIPTION
	ORDER BY SKILL.SKI_TYPE ASC;