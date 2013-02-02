PROGRAM SUM_OF_2_10;

var
    NUM1 : ARRAY [1 .. 10] OF CHAR;
    NUM2 : ARRAY [1 .. 10] OF CHAR;
    SUM  : ARRAY [1 .. 11] OF CHAR;
    COUNT : INTEGER;
    TEMP : INTEGER;

BEGIN
    writeln('please enter first 10 digit number : ');
    readln(NUM1);
    writeln('please enter second 10 digit number : ');
    readln(NUM2);
    TEMP := 0;

    for COUNT := 10 downto 1 do
        BEGIN
             TEMP:=(INTEGER(NUM1[COUNT])-48) + (INTEGER(NUM2[COUNT]) -48)+TEMP;
             SUM[COUNT + 1] := CHAR((TEMP MOD 10) + 48);
             TEMP := TEMP DIV 10;
             TEMP := TEMP MOD 10;
        END;
    if ((TEMP MOD 10) > 0) THEN
       SUM[1] := CHAR((TEMP MOD 10) +48);
    write('sum is : ');
    for COUNT := 1 to 11 do
        write(sum[COUNT]);

END.

