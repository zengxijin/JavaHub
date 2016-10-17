
drop table xnl_sys_cfg;
create table xnl_sys_cfg(
id number(6),
cfg_key varchar2(256),
cfg_val varchar2(512),
cfg_type varchar2(128),
create_time date

constraint pk_id primary key(id)

);

drop sequence seq_xnl_sys_cfg;
create sequence seq_xnl_sys_cfg
increment by 1
start with 1
maxvalue 9999999
minvalue 1
NOCYCLE
nocache

--使用示例
--insert xnl_sys_cfg(id,cfg_key,cfg_val,cfg_type,create_time) values(seq_xnl_sys_cfg.nextval,'mykey','myval','mytype',sysdate)
