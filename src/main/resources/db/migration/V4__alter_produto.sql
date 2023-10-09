ALTER TABLE produto
ADD COLUMN estado TINYINT;

UPDATE produto SET estado = 1 WHERE estado IS NULL;