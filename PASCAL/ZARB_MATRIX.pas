PROGRAM ZARB_MATRIX;

var
   a : array[1..10,1..10] of integer;
   b : array[1..10,1..10] of integer;
   c : array[1..10,1..10] of integer;
   m1,n1,m2,n2,i,j,sum,k : integer;
begin
     writeln('enter number of row for matrix A');
     readln(m1);
     writeln('enter number of col for matrix A');
     readln(n1);
     writeln('enter number of row for matrix B');
     readln(m2);
     writeln('enter number of col for matrix B');
     readln(n2);

     if n1=m2 then
       begin
        writeln('Enter Number Of Mutrix A');
        for i:=1 to m1 do
            for j:=1 to n1 do
                begin
                    writeln('Enter A[',i,j,']');
                    read(a[i,j]);
                end;
        writeln('Entering Number Of Matrix A compilited');
        writeln('Now Enter Number Of Matrix B');

        for i:=1 to m2 do
            for j:= 1 to n2 do
                begin
                     writeln('Enter B[',i,j,']');
                     read(b[i,j]);
                end;
        writeln('Entering Number Of Matrix B compilited');
        writeln;

        for i:= 1 to m1 do
            begin
                 for j:= 1 to n2 do
                     begin
                          for k:= 1 to n1 do
                              sum:=sum+(a[i,k]*b[k,j]);
                          c[i,j]:= sum;
                          sum:=0;
                     end;
              
            end;
        writeln('Matrix[A]');
        for i:= 1 to m1 do
            for j:=1 to n1 do
                if j=n1 then
                   writeln(a[i,j]:4)
                else
                    write(a[i,j]:4);
        writeln('************************');
        writeln('Matrix[B]');
        for i:= 1 to m2 do
            for j:=1 to n2 do
                if j=n2 then
                   writeln(b[i,j]:4)
                else
                    write(b[i,j]:4);
        writeln('************************');
        writeln('Zarbe Do matrix dar ham: ');
        for i:= 1 to m1 do
            for j:=1 to n2 do
                if j=n2 then
                   writeln(c[i,j]:4)
                else
                    write(c[i,j]:4);
       
       end
     else
         writeln('Matris ha Zarb Pazir Nistand');
end.


