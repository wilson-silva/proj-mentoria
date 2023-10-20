CREATE TABLE `tb_usuario` (
  `id_usuario` binary(16) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
   PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_plh3sd5xqp709wamcutkiq85m` (`username`)
);


INSERT INTO tb_usuario (id_usuario, password, username, role) VALUES
(UUID_TO_BIN('fc827ff6-6c9e-11ee-b962-0242ac120002'), '$2a$10$I1hxM09wnjf3PP7o/4rAIeDckT4qKHpUNeyioo3SlxaIvJuyAOIfe', 'willsilva', 'ADMIN'),
(UUID_TO_BIN('4552ba4c-6ca0-11ee-b962-0242ac120002'), '$2a$10$44fj4R9EgPtFgm22CIfibe2bF8Ffe1DnbjUsnwDTptZp0RWFzUD9i', 'katysilva','USER');





