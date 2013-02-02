PROGRAM TRANHADE;

CONST
     n = 5;
var
   i : INTEGER;
   j : INTEGER;
   a : ARRAY [1..n,1..n] OF INTEGER;
BEGIN
    writeln('please enter numbers of matrix : ');
    for i:= 1 to n do
        for j:= 1 to n do
            BEGIN
                 writeln('a[', i, j,'] : ');
                 read(a[i,j]);
            END;
    writeln;
    for i:=1 to n do
        BEGIN
             for j:=1 to n do
                 BEGIN
                      write(a[j,i]);
                      write(' ');
                 END;
             writeln;
        END;
END.
