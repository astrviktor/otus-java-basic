CREATE TABLE test
(
    id bigint PRIMARY KEY,
    title text
);

CREATE TABLE question
(
    id bigint PRIMARY KEY,
    test_id bigint REFERENCES test (id),
    content text
);

CREATE TABLE answer
(
    id SERIAL PRIMARY KEY,
    question_id bigint REFERENCES question (id),
    content text,
    correct boolean
);

INSERT INTO test(id, title) VALUES (1, 'Логика');

INSERT INTO question(id, test_id, content) VALUES (1, 1, 'Кто из мыслителей открыл закон достаточного основания и сформулировал его сущность?');

INSERT INTO answer(question_id, content, correct) VALUES (1, 'Демокрит', false);
INSERT INTO answer(question_id, content, correct) VALUES (1, 'Лейбниц', true);
INSERT INTO answer(question_id, content, correct) VALUES (1, 'Фихте', false);
INSERT INTO answer(question_id, content, correct) VALUES (1, 'Аристотель', false);
INSERT INTO answer(question_id, content, correct) VALUES (1, 'Гегель', false);

INSERT INTO question(id, test_id, content) VALUES (2, 1, 'Научный метод, разработанный английским мыслителем XVII в. Ф. Бэконом, называется эмпиризм. Какая логическая форма умозаключения лежит в его основе?');

INSERT INTO answer(question_id, content, correct) VALUES (2, 'Индукция', true);
INSERT INTO answer(question_id, content, correct) VALUES (2, 'Аналогия', false);
INSERT INTO answer(question_id, content, correct) VALUES (2, 'Дедукция', false);
