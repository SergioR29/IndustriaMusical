BEGIN
   FOR cur IN (SELECT table_name FROM user_tables) LOOP
      EXECUTE IMMEDIATE 'DROP TABLE ' || cur.table_name || ' CASCADE CONSTRAINTS';
   END LOOP;
   
   FOR cur IN (SELECT type_name FROM user_types) LOOP
      EXECUTE IMMEDIATE 'DROP TYPE ' || cur.type_name || ' FORCE';
   END LOOP;
   
END;
/