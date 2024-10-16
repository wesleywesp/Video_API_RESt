CREATE TABLE categorias (
    id BIGINT NOT NULL AUTO_INCREMENT,
    categoria_enum VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) CHARSET=utf8mb4;

-- Passo 2: Adicionar a coluna categoria_id na tabela videos
ALTER TABLE videos ADD COLUMN categoria_id BIGINT;

-- Passo 3: Criar uma categoria padrão chamada "SEM_CATEGORIA"
INSERT INTO categorias (categoria_enum) VALUES ('SEM_CATEGORIA');

-- Passo 4: Atualizar todos os vídeos existentes para associá-los à categoria padrão
UPDATE videos SET categoria_id = (SELECT id FROM categorias WHERE categoria_enum = 'SEM_CATEGORIA');

-- Passo 5: Definir a coluna categoria_id como chave estrangeira que referencia a tabela categorias
ALTER TABLE videos ADD CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id);