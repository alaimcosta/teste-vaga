CREATE TABLE `tecnico`(
    `id_tecnico` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(100) NOT NULL,
    `cpf` VARCHAR(20) NOT NULL,
    `turno` BIGINT NOT NULL,
    `departamento` BIGINT NOT NULL
);
CREATE TABLE `cliente`(
    `id_cliente` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(100) NOT NULL,
    `endereco` VARCHAR(100) NOT NULL,
    `cpf_cnpj` VARCHAR(20) NOT NULL
);
CREATE TABLE `permissao`(
    `id_permissao` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_group` BIGINT NOT NULL,
    `id_visita` BIGINT NOT NULL,
    `create` BIGINT NOT NULL,
    `delete` BIGINT NOT NULL,
    `update` BIGINT NOT NULL
);
ALTER TABLE
    `permissao` ADD INDEX `permissao_id_group_index`(`id_group`);
ALTER TABLE
    `permissao` ADD INDEX `permissao_id_visita_index`(`id_visita`);
CREATE TABLE `visita_tecnica`(
    `id_visita` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_tecnico` BIGINT NOT NULL,
    `id_cliente` BIGINT NOT NULL,
    `protocolo_chamado` BIGINT NOT NULL,
    `data_visita` DATE NOT NULL,
    `laudo_visita` VARCHAR(255) NOT NULL
);
CREATE TABLE `login`(
    `id_login` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `emailLogin` VARCHAR(100) NOT NULL,
    `senhaLogin` BIGINT NOT NULL
);
CREATE TABLE `usuario`(
    `id_usuario` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `senha` BIGINT NOT NULL,
    `id_login` BIGINT NOT NULL
);
ALTER TABLE
    `usuario` ADD INDEX `usuario_id_login_index`(`id_login`);
CREATE TABLE `group_acess`(
    `id_group` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `descricao` VARCHAR(255) NOT NULL,
    `id_usuario` BIGINT NOT NULL
);
ALTER TABLE
    `group_acess` ADD INDEX `group_acess_id_usuario_index`(`id_usuario`);
ALTER TABLE
    `permissao` ADD CONSTRAINT `permissao_id_visita_foreign` FOREIGN KEY(`id_visita`) REFERENCES `visita_tecnica`(`id_visita`);
ALTER TABLE
    `permissao` ADD CONSTRAINT `permissao_id_group_foreign` FOREIGN KEY(`id_group`) REFERENCES `group_acess`(`id_group`);
ALTER TABLE
    `group_acess` ADD CONSTRAINT `group_acess_id_usuario_foreign` FOREIGN KEY(`id_usuario`) REFERENCES `usuario`(`id_usuario`);
ALTER TABLE
    `visita_tecnica` ADD CONSTRAINT `visita_tecnica_id_cliente_foreign` FOREIGN KEY(`id_cliente`) REFERENCES `cliente`(`id_cliente`);
ALTER TABLE
    `visita_tecnica` ADD CONSTRAINT `visita_tecnica_id_tecnico_foreign` FOREIGN KEY(`id_tecnico`) REFERENCES `tecnico`(`id_tecnico`);
ALTER TABLE
    `usuario` ADD CONSTRAINT `usuario_id_login_foreign` FOREIGN KEY(`id_login`) REFERENCES `login`(`id_login`);