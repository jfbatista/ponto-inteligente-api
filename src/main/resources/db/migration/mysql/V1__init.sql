create table `empresa` (
 `empresa_id` bigint(20) NOT NULL AUTO_INCREMENT,
 `cnpj` char(14) NOT NULL,
 `data_criacao` datetime NOT NULL,
 `data_atualizacao` datetime not null,
 `razao_social` varchar(255) not null,
  primary key (empresa_id)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `funcionario` (
 `funcionario_id` bigint(20) NOT NULL AUTO_INCREMENT,
 `cpf` char(11) NOT NULL,
 `data_criacao` datetime NOT NULL,
 `data_atualizacao` datetime not null,
 `nome` varchar(255) not null,
 `email` varchar(255) not null,
 `senha` varchar(255) not null,
 `perfil` varchar(255) not null,
 `qtd_horas_almoco` float default null,
 `qtd_horas_trabalho_dia` float default null,
 `empresa_id` bigint(20) default null,
  primary key (funcionario_id)
)engine=InnoDB DEFAULT CHARSET=utf8;

create table `lancamento` (
 `lancamento_id` bigint(20) NOT NULL AUTO_INCREMENT,
 `data` datetime NOT NULL,
 `data_criacao` datetime NOT NULL,
 `data_atualizacao` datetime not null,
 `descricao` varchar(255) not null,
 `localizacao` varchar(255) not null,
 `tipo` varchar(255) not null,
 `funcionario_id` bigint(20) default null,
  primary key (lancamento_id)
)engine=InnoDB DEFAULT CHARSET=utf8;

alter table `funcionario` add key `fk_funcionario_empresa` (`empresa_id`);
alter table `lancamento` add key `fk_lancamento_funcionario` (`funcionario_id`);

alter table `funcionario` add CONSTRAINT `fk_funcionario_empresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`empresa_id`);
alter table `lancamento` add CONSTRAINT `fk_lancamento_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`funcionario_id`);



