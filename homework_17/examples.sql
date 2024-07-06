-- Список тестов
SELECT * FROM test;

-- Список вопросов в тесте 1
SELECT * FROM question WHERE test_id = 1;

SELECT
    t.title,
    q.id,
    q.content
FROM test t
LEFT JOIN question q ON q.test_id = t.id
WHERE t.id = 1;


-- Список ответов на вопрос 1
SELECT * FROM answer WHERE question_id = 1;

SELECT
    q.id,
    q.content as question,
    a.content as answer,
    a.correct
FROM question q
LEFT JOIN answer a ON q.id = a.question_id
WHERE q.id = 1;
