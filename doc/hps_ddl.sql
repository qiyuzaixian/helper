----------------------------------------------
-- Export file for user ZBT                 --
-- Created by lenovo on 2019/1/18, 17:15:36 --
----------------------------------------------

set define off
spool hps_20190118.log

prompt
prompt Creating table HPS_CREDITS_BEHAVIOR
prompt ===================================
prompt
create table HPS_CREDITS_BEHAVIOR
(
  id               NUMBER(11) not null,
  behavior_id      VARCHAR2(11),
  behavior_name    VARCHAR2(60),
  parent_id        VARCHAR2(11),
  is_show          NUMBER(4),
  behavior_remarks CHAR(10),
  create_dt        TIMESTAMP(6),
  create_oper      VARCHAR2(11),
  update_dt        TIMESTAMP(6),
  update_oper      VARCHAR2(11),
  status           NUMBER(4),
  del_flag         NUMBER(4),
  remarks          VARCHAR2(1000)
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table HPS_CREDITS_BEHAVIOR
  is '积分行为对象表';
comment on column HPS_CREDITS_BEHAVIOR.id
  is '索引';
comment on column HPS_CREDITS_BEHAVIOR.behavior_id
  is '积分行为索引';
comment on column HPS_CREDITS_BEHAVIOR.behavior_name
  is '积分行为名称';
comment on column HPS_CREDITS_BEHAVIOR.parent_id
  is '父积分行为索引';
comment on column HPS_CREDITS_BEHAVIOR.is_show
  is '是否显示';
comment on column HPS_CREDITS_BEHAVIOR.behavior_remarks
  is '积分行为备注';
comment on column HPS_CREDITS_BEHAVIOR.create_dt
  is '创建时间';
comment on column HPS_CREDITS_BEHAVIOR.create_oper
  is '创建者';
comment on column HPS_CREDITS_BEHAVIOR.update_dt
  is '最后更新时间';
comment on column HPS_CREDITS_BEHAVIOR.update_oper
  is '最后更新者';
comment on column HPS_CREDITS_BEHAVIOR.status
  is '状态';
comment on column HPS_CREDITS_BEHAVIOR.del_flag
  is '是否删除';
comment on column HPS_CREDITS_BEHAVIOR.remarks
  is '备注';
alter table HPS_CREDITS_BEHAVIOR
  add primary key (ID)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table HPS_CREDITS_RECORD
prompt =================================
prompt
create table HPS_CREDITS_RECORD
(
  id                  NUMBER(11) not null,
  credits_record_id   VARCHAR2(11),
  credits_behavior_id VARCHAR2(11),
  user_id             VARCHAR2(11),
  credits_state       VARCHAR2(11),
  credits_dt          TIMESTAMP(6),
  credits_type        VARCHAR2(11),
  credits_content     VARCHAR2(1000),
  credits_rule_id     VARCHAR2(11),
  credits_value       NUMBER(11),
  create_dt           TIMESTAMP(6),
  create_oper         VARCHAR2(30),
  update_dt           TIMESTAMP(6),
  update_oper         VARCHAR2(30),
  status              NUMBER(4),
  del_flag            NUMBER(4),
  remarks             VARCHAR2(1000)
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table HPS_CREDITS_RECORD
  is '积分记录表';
comment on column HPS_CREDITS_RECORD.id
  is '索引';
comment on column HPS_CREDITS_RECORD.credits_record_id
  is '积分记录索引';
comment on column HPS_CREDITS_RECORD.credits_behavior_id
  is '积分行为索引';
comment on column HPS_CREDITS_RECORD.user_id
  is 'yong户索引';
comment on column HPS_CREDITS_RECORD.credits_state
  is '积分状态（消费积分或添加积分）';
comment on column HPS_CREDITS_RECORD.credits_dt
  is '积分时间';
comment on column HPS_CREDITS_RECORD.credits_type
  is '积分行为类型';
comment on column HPS_CREDITS_RECORD.credits_content
  is '积分内容';
comment on column HPS_CREDITS_RECORD.credits_rule_id
  is '积分规则索引';
comment on column HPS_CREDITS_RECORD.credits_value
  is '积分值';
comment on column HPS_CREDITS_RECORD.create_dt
  is '创建时间';
comment on column HPS_CREDITS_RECORD.create_oper
  is '创建者';
comment on column HPS_CREDITS_RECORD.update_dt
  is '最后更新时间';
comment on column HPS_CREDITS_RECORD.update_oper
  is '最后更新者';
comment on column HPS_CREDITS_RECORD.status
  is '状态(索引)';
comment on column HPS_CREDITS_RECORD.del_flag
  is '是否删除';
comment on column HPS_CREDITS_RECORD.remarks
  is '备注';
alter table HPS_CREDITS_RECORD
  add primary key (ID)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table HPS_CREDITS_RULE
prompt ===============================
prompt
create table HPS_CREDITS_RULE
(
  id                   NUMBER(11) not null,
  credits_rule_id      VARCHAR2(11),
  member_id            VARCHAR2(11),
  credits_type_id      VARCHAR2(11),
  credits_rule_content VARCHAR2(1000),
  credits_action_id    VARCHAR2(11),
  max_value            NUMBER(18,6),
  min_value            NUMBER(18,6),
  credits_vallue       NUMBER(18,6),
  is_repeat            NUMBER(4),
  credits_upper_value  NUMBER(18,6),
  start_credits_dt     TIMESTAMP(6),
  end_credits_dt       TIMESTAMP(6),
  create_dt            TIMESTAMP(6),
  update_dt            TIMESTAMP(6),
  create_oper          VARCHAR2(11),
  update_oper          VARCHAR2(11),
  status               NUMBER(4),
  del_flag             NUMBER(4),
  remarks              VARCHAR2(1000),
  model_type           NUMBER(1)
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table HPS_CREDITS_RULE
  is '积分规则表';
comment on column HPS_CREDITS_RULE.id
  is '索引';
comment on column HPS_CREDITS_RULE.credits_rule_id
  is '积分规则索引';
comment on column HPS_CREDITS_RULE.member_id
  is '会员索引';
comment on column HPS_CREDITS_RULE.credits_type_id
  is '积分规则分类索引';
comment on column HPS_CREDITS_RULE.credits_rule_content
  is '积分规则内容';
comment on column HPS_CREDITS_RULE.credits_action_id
  is '积分动作编号索引';
comment on column HPS_CREDITS_RULE.max_value
  is '最大值';
comment on column HPS_CREDITS_RULE.min_value
  is '最小值';
comment on column HPS_CREDITS_RULE.credits_vallue
  is '积分值';
comment on column HPS_CREDITS_RULE.is_repeat
  is '是否每天一次性';
comment on column HPS_CREDITS_RULE.credits_upper_value
  is '每天积分上限值（0-不限制）';
comment on column HPS_CREDITS_RULE.start_credits_dt
  is '生效时间';
comment on column HPS_CREDITS_RULE.end_credits_dt
  is '结束时间';
comment on column HPS_CREDITS_RULE.create_dt
  is '创建时间';
comment on column HPS_CREDITS_RULE.update_dt
  is '最后更新时间';
comment on column HPS_CREDITS_RULE.create_oper
  is '创建者';
comment on column HPS_CREDITS_RULE.update_oper
  is '最后更新者';
comment on column HPS_CREDITS_RULE.status
  is '积分规则状态(索引)';
comment on column HPS_CREDITS_RULE.del_flag
  is '积分规则是否删除';
comment on column HPS_CREDITS_RULE.remarks
  is '备注';
comment on column HPS_CREDITS_RULE.model_type
  is '代表模板（0 管理员可见  1 普通用户可见）';
alter table HPS_CREDITS_RULE
  add primary key (ID)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table HPS_CREDITS_TYPE
prompt ===============================
prompt
create table HPS_CREDITS_TYPE
(
  id                   NUMBER(11) not null,
  credits_type_id      VARCHAR2(11),
  member_id            VARCHAR2(11),
  credits_type_name    VARCHAR2(60),
  user_level_id        VARCHAR2(11),
  credits_type_content VARCHAR2(1000),
  create_dt            TIMESTAMP(6),
  update_dt            TIMESTAMP(6),
  status               NUMBER(4),
  del_flag             NUMBER(4),
  create_oper          VARCHAR2(11),
  update_oper          VARCHAR2(11),
  remarks              VARCHAR2(1000),
  cb_id                VARCHAR2(50)
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table HPS_CREDITS_TYPE
  is '积分规则分类表';
comment on column HPS_CREDITS_TYPE.id
  is '索引';
comment on column HPS_CREDITS_TYPE.credits_type_id
  is '积分规则分类ID';
comment on column HPS_CREDITS_TYPE.member_id
  is '会员ID';
comment on column HPS_CREDITS_TYPE.credits_type_name
  is '积分规则分类名称';
comment on column HPS_CREDITS_TYPE.user_level_id
  is '用户等级ID';
comment on column HPS_CREDITS_TYPE.credits_type_content
  is '积分规则分类说明';
comment on column HPS_CREDITS_TYPE.create_dt
  is '创建时间';
comment on column HPS_CREDITS_TYPE.update_dt
  is '最后更新时间';
comment on column HPS_CREDITS_TYPE.status
  is '积分规则分类状态(索引)';
comment on column HPS_CREDITS_TYPE.del_flag
  is '积分规则分类是否删除';
comment on column HPS_CREDITS_TYPE.create_oper
  is '创建者';
comment on column HPS_CREDITS_TYPE.update_oper
  is '最后更新者';
comment on column HPS_CREDITS_TYPE.remarks
  is '备注';
comment on column HPS_CREDITS_TYPE.cb_id
  is '积分行为id';
alter table HPS_CREDITS_TYPE
  add primary key (ID)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table HPS_HELPER_INFO
prompt ==============================
prompt
create table HPS_HELPER_INFO
(
  id              NUMBER not null,
  type_id         NUMBER not null,
  helper_type     NUMBER not null,
  title           VARCHAR2(150 CHAR),
  content         VARCHAR2(1000 CHAR),
  image_url       VARCHAR2(300 CHAR),
  file_url        VARCHAR2(300 CHAR),
  src_of_resource VARCHAR2(30 CHAR),
  text            VARCHAR2(1024),
  status          VARCHAR2(1 CHAR) default '1',
  create_user     VARCHAR2(9 CHAR),
  release_date    DATE
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table HPS_HELPER_INFO
  is '助手信息发布';
comment on column HPS_HELPER_INFO.id
  is '主键';
comment on column HPS_HELPER_INFO.type_id
  is '信息类别，1.线上课程2.病例分析3.学习路径';
comment on column HPS_HELPER_INFO.helper_type
  is '产品类别,1.脑心通，2.稳心3....';
comment on column HPS_HELPER_INFO.title
  is '信息标题';
comment on column HPS_HELPER_INFO.content
  is '发布内容';
comment on column HPS_HELPER_INFO.image_url
  is '封面图片及介绍图片（同一张图片，如需缩略图再加）';
comment on column HPS_HELPER_INFO.file_url
  is '资料文件路径';
comment on column HPS_HELPER_INFO.src_of_resource
  is '该信息出处（可描述可链接也可以为空）';
comment on column HPS_HELPER_INFO.text
  is '图文模式（如果需求内容较大，改为clob,但clob性能较差）';
comment on column HPS_HELPER_INFO.status
  is '状态：1.有效 0.无效';
comment on column HPS_HELPER_INFO.create_user
  is '发布者';
comment on column HPS_HELPER_INFO.release_date
  is '发布日期';
alter table HPS_HELPER_INFO
  add constraint HELPER_INFO_PK primary key (ID, TYPE_ID, HELPER_TYPE)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table HPS_HELPER_TYPE
prompt ==============================
prompt
create table HPS_HELPER_TYPE
(
  id        NUMBER not null,
  type_id   NUMBER not null,
  type_name VARCHAR2(32)
)
tablespace ZBTSPACE
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table HPS_HELPER_TYPE
  is '助手类别表';
comment on column HPS_HELPER_TYPE.id
  is '主键';
comment on column HPS_HELPER_TYPE.type_id
  is '类别ID';
comment on column HPS_HELPER_TYPE.type_name
  is '类别名称';
alter table HPS_HELPER_TYPE
  add constraint HELPER_TYPE_PK primary key (ID)
  using index
  tablespace ZBTSPACE
  pctfree 10
  initrans 2
  maxtrans 255;


spool off
