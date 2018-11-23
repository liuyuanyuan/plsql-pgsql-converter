
----package name(package->package.function) example-----
/* oracle */
/*create package (package -> schema)*/
create or replace package pkg_lyy
as
    procedure spStr(str out varchar);
end pkg_lyy;
/
/*create package body(package procedure/function -> package.procedure/function)*/
create or replace package body pkg_lyy
as
    procedure spStr(str out varchar)
    is
    begin
        select name into str from lyy where id=1;
    end spStr;
end pkg_lyy;
/
/*into PG*/
create or replace function PKG_LYY.SPSTR (str OUT varchar)
returns varchar
as $$
# variable_conflict use_column
begin
  select name
  into str
  from lyy
  where id = 1
  ;
end;
$$
language plpgsql;




----comment example----
/* oracle */
CREATE OR REPLACE PROCEDURE test.testcmt(id int)
  is
  /* c line1
  /* c line2
  /* cline3 */
  num int;
begin
  select id into num from lyy;
end;
/
/* converted into PG */
create or replace function test.testcmt (id /*  c line1
  c line2
  cline3   */ integer)
returns void
as $$
# variable_conflict use_column
declare
  num integer;
begin
  select id
  into strict num
  from lyy
  ;
end;
$$
language plpgsql;




----- left join and into strict example -----
/* oracle */
CREATE OR REPLACE function TEST.testjoin
   return int
   is
   age int;
begin
 select lyy2.age into age from lyy,lyy2 where lyy.id=lyy2.id(+);
 return age;
end;
/
/* converted into PG */
create or replace function test.testjoin ()
returns integer
as $$
#variable_conflict use_column
declare
  age integer;
begin
  select lyy2.age
  into age # into strict age # PG strict only support null or one record
  from lyy
  left join lyy2 on lyy.id = lyy2.id
  ;
  return age;
end;
$$
language plpgsql;

------Remove <name> after END from tokens(PG not support END <name>).--------
/* oracle */
# create 
create or replace procedure test_endname(str out varchar(20)
as
begin
   select name into str from lyy where id=1;
end test_endname;
# execute
SQL> var str varchar2(20);
SQL> exec test_endname(:str);
PL/SQL 过程已成功完成。
SQL> print str
STR
--------------
lyy
# or
SQL> select :str from dual;
:STR
--------------
lyy

/*into PG*/
create or replace function TEST.test_endname (str OUT lyy.name%type)
returns lyy.name%type
as $$
#variable_conflict use_column
begin
  select name
  into str
  from lyy
  where id = 1
  ;
end ;
$$
language plpgsql;




