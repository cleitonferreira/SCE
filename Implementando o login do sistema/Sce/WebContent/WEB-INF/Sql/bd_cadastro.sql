/*==============================================================*/
/* Table: ACESSO                                                */
/*==============================================================*/
create table ACESSO (
   CODIGO               SERIAL               not null,
   COMANDO              VARCHAR(45)          null,
   DESCRICAO            VARCHAR(60)          null,
   constraint PK_ACESSO primary key (CODIGO)
);

/*==============================================================*/
/* Index: ACESSO_PK                                             */
/*==============================================================*/
create unique index ACESSO_PK on ACESSO (
CODIGO
);

/*==============================================================*/
/* Table: ACESSO_USUARIO                                        */
/*==============================================================*/
create table ACESSO_USUARIO (
   USU_CODIGO           INT4                 not null,
   CODIGO               INT4                 not null,
   constraint PK_ACESSO_USUARIO primary key (USU_CODIGO, CODIGO)
);

/*==============================================================*/
/* Index: ACESSO_USUARIO_PK                                     */
/*==============================================================*/
create unique index ACESSO_USUARIO_PK on ACESSO_USUARIO (
USU_CODIGO,
CODIGO
);

/*==============================================================*/
/* Index: ACESSO_USUARIO_FK                                     */
/*==============================================================*/
create  index ACESSO_USUARIO_FK on ACESSO_USUARIO (
USU_CODIGO
);

/*==============================================================*/
/* Index: ACESSO_USUARIO2_FK                                    */
/*==============================================================*/
create  index ACESSO_USUARIO2_FK on ACESSO_USUARIO (
CODIGO
);


/*==============================================================*/
/* Table: CIDADE                                                */
/*==============================================================*/
create table CIDADE (
   CID_CODIGO           SERIAL               not null,
   CID_NOME             VARCHAR(30)          not null,
   CID_UF               VARCHAR(2)           null,
   constraint PK_CIDADE primary key (CID_CODIGO)
);

/*==============================================================*/
/* Index: CIDADE_PK                                             */
/*==============================================================*/
create unique index CIDADE_PK on CIDADE (
CID_CODIGO
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   CLI_CODIGO           SERIAL               not null,
   CID_CODIGO           INT4                 not null,
   CLI_NOME             VARCHAR(40)          not null,
   CLI_ENDERECO         VARCHAR(40)          null,
   CLI_BAIRRO           VARCHAR(40)          null,
   CLI_NUMERO           VARCHAR(10)          null,
   CLI_COMPLEMENTO      VARCHAR(10)          null,
   CLI_CEP              CHAR(9)              null,
   CLI_CPF              CHAR(14)             null,
   CLI_RG               VARCHAR(12)          null,
   CLI_CNPJ             VARCHAR(18)          null,
   CLI_INSEST           VARCHAR(20)          null,
   CLI_FONERES          CHAR(14)             null,
   CLI_FONECEL          CHAR(14)             null,
   CLI_DATANASC         DATE                 null,
   CLI_DATACAD          DATE                 null,
   CLI_EMAIL            VARCHAR(50)          null,
   CLI_SEXO             CHAR(1)              null,
   CLI_ESTADOCIVIL      CHAR(1)              null,
   CLI_OBS              VARCHAR(100)         null,
   constraint PK_CLIENTE primary key (CLI_CODIGO)
);

/*==============================================================*/
/* Index: CLIENTE_PK                                            */
/*==============================================================*/
create unique index CLIENTE_PK on CLIENTE (
CLI_CODIGO
);

/*==============================================================*/
/* Index: CIDADE_DO_CLIENTE_FK                                  */
/*==============================================================*/
create  index CIDADE_DO_CLIENTE_FK on CLIENTE (
CID_CODIGO
);



create table USUARIO (
   USU_CODIGO           SERIAL               not null,
   USU_NOME             VARCHAR(40)          null,
   USU_LOGIN            VARCHAR(10)          null,
   USU_SENHA            VARCHAR(10)          null,
   constraint PK_USUARIO primary key (USU_CODIGO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
USU_CODIGO
);



alter table ACESSO_USUARIO
   add constraint FK_ACESSO_U_ACESSO_US_USUARIO foreign key (USU_CODIGO)
      references USUARIO (USU_CODIGO)
      on delete restrict on update restrict;

alter table ACESSO_USUARIO
   add constraint FK_ACESSO_U_ACESSO_US_ACESSO foreign key (CODIGO)
      references ACESSO (CODIGO)
      on delete restrict on update restrict;
