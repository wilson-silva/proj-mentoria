ALTER TABLE categoria
ADD COLUMN estado TINYINT;

UPDATE categoria SET estado = 1 WHERE estado IS NULL;