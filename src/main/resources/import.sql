-- Inserir dados na tabela GrupoMuscular
INSERT INTO tb_grupomuscular (nome) VALUES ('Superiores');
INSERT INTO tb_grupomuscular (nome) VALUES ('Inferiores');

-- Inserir dados na tabela Exercicios, referenciando os IDs existentes na tabela GrupoMuscular
INSERT INTO tb_exercicios (nome, qtd_series, qtd_reps, grupo_id) VALUES ('Exercicio 1', 3, 10, 1); -- Inserindo um exercício no Grupo Muscular A
INSERT INTO tb_exercicios (nome, qtd_series, qtd_reps, grupo_id) VALUES ('Exercicio 2', 4, 12, 2); -- Inserindo um exercício no Grupo Muscular B
