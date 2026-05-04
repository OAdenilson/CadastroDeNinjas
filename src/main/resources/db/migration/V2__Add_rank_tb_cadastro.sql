-- V2: Migrations para adicionar a Coluna de RANK na Tabela de Cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
