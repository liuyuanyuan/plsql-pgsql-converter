
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
#variable_conflict use_column
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


----- left join example -----
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






