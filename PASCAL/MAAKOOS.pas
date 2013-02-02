PROGRAM MAAKOOS;

CONST
     n = 3;

var
   a : ARRAY [1..n] OF INTEGER;
   i : INTEGER;

BEGIN
    for i:= 1 to n do
        BEGIN
             writeln('please enter item ', i ,' of array : ');
             read(a[i]);
        END;
    writeln('original array is : ');
    for i:=1 to n do
        write(a[i] , ' ');
    writeln;
    writeln('array maakoos is : ');
    for i:=1 to n do
        write(1 / a[i],' ');
END.
