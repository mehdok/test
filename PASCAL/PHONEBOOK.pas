PROGRAM PHONEBOOK;

        CONST
             n = 5; {number of total contact}

        TYPE
            contact_rec = RECORD
                        name : STRING;
                        family : STRING;
                        code : STRING;
                        number : STRING;
                        address : String;
            END;
            contact_arr = ARRAY[1..n] OF contact_rec;

        VAR
           contact : contact_arr;
           input : INTEGER;
           item : INTEGER ;
           key : STRING;
           i,j : INTEGER;
           index : INTEGER;

           contactFile : TEXT;

        PROCEDURE showMessage; FORWARD; {Pre-Declare "showMessage" procedure}

        PROCEDURE addContact;
        BEGIN
             writeln('Enter NAME    : ');
             readln(contact[item].name);
             writeln('Enter FAMILY  : ');
             readln(contact[item].family);
             writeln('Enter CODE    : ');
             readln(contact[item].code);
             writeln('Enter NUMBER  : ');
             readln(contact[item].number);
             writeln('Enter ADDRESS : ');
             readln(contact[item].address);
             item := item + 1;
             showMessage;
        END;

        PROCEDURE showContact(x : INTEGER);
        BEGIN
             writeln('CONTACT ', x, ' : ');
             writeln;
             writeln('NAME    : ', contact[x].name);
             writeln('FAMILY  : ', contact[x].family);
             writeln('CODE    : ', contact[x].code);
             writeln('NUMBER  : ', contact[x].number);
             writeln('ADDRESS : ', contact[x].address);
             writeln;
             writeln;
             showMessage;
        END;

        PROCEDURE showAll;
        BEGIN
             FOR i := 1 TO item-1 DO
             BEGIN
                  writeln('CONTACT ', i, ' : ');
                  writeln;
                  writeln('NAME    : ', contact[i].name);
                  writeln('FAMILY  : ', contact[i].family);
                  writeln('CODE    : ', contact[i].code);
                  writeln('NUMBER  : ', contact[i].number);
                  writeln('ADDRESS : ', contact[i].address);
                  writeln;
                  writeln;
             END;
             showMessage;
        END;

        PROCEDURE search;
        BEGIN
             writeln('Please Enter Family Of Contact : ');
             readln(key);
             for i := 1 to item-1 do
                 BEGIN
                      IF (key = contact[i].family) THEN
                         showContact(i);
                 END;
             writeln('Your Entered Family Is NOT In The Contact List');
             showMessage;
        END;

        PROCEDURE sort;
            var
               tempName : STRING;
               tempFamily : STRING;
               tempCode : STRING;
               tempNumber : STRING;
               tempAddress : STRING;
        BEGIN
             FOR i := 1 TO item-1 DO
                 FOR j:= i+1 TO item-1 DO
                      IF(contact[i].family > contact[j].family) THEN
                      BEGIN
                           tempName := contact[i].name;
                           tempFamily := contact[i].family;
                           tempCode := contact[i].code;
                           tempNumber := contact[i].number;
                           tempAddress := contact[i].address;

                           contact[i].name := contact[j].name;
                           contact[i].family := contact[j].family;
                           contact[i].code := contact[j].code;
                           contact[i].number := contact[j].number;
                           contact[i].address := contact[j].address;

                           contact[j].name := tempName;
                           contact[j].family := tempFamily;
                           contact[j].code := tempCode;
                           contact[j].number := tempNumber;
                           contact[j].address := tempAddress;
                      END;
             writeln('Sort DONE');
             showMessage;
        END;

        PROCEDURE editContact;
           var
              tempName : STRING;
              tempFamily : STRING;
              tempCode : STRING;
              tempNumber : STRING;
              tempAddress : STRING;
        BEGIN
           writeln('Please Enter INDEX Of Contact You Want To Edit : ');
           readln(index);
           writeln('Name Of Contact ', index, ' is "', contact[index].name,
                         ' " Enter New Name For It : ');
           readln(tempName);
           contact[i].name := tempName;
           writeln('Family Of Contact ', index,' is "',contact[index].family,
                           ' " Enter New Family For It : ');
           readln(tempFamily);
           contact[i].family := tempFamily;
           writeln('Code Of Contact ', index, ' is "', contact[index].code,
                         ' " Enter New Code For It : ');
           readln(tempCode);
           contact[i].code := tempCode;
           writeln('Number Of Contact ', index,' is "',contact[index].number,
                           ' " Enter New number For It : ');
           readln(tempNumber);
           contact[i].number := tempNumber;
           writeln('Address Of Contact ',index,' is "',contact[index].address,
                            ' " Enter New Address For It : ');
           readln(tempAddress);
           contact[i].address := tempAddress;

           writeln;
           writeln;
           showMessage;
        END;

        PROCEDURE deleteContact;
           var
              tempNumber : String;
        BEGIN
             writeln('Enter NUMBER Of Contact You Want To Delete : ');
             readln(tempNumber);
             index := 0;
             FOR i := 1 TO item-1 DO
                 IF (tempNumber = contact[i].number) THEN
                    index := i;
             IF( index = 0) THEN
                 writeln('No Contact Found With These Number')
             ELSE
                 BEGIN
                      FOR i := index TO item-1 DO
                      BEGIN
                           contact[i].name := contact[i+1].name;
                           contact[i].family := contact[i+1].family;
                           contact[i].code := contact[i+1].code;
                           contact[i].number := contact[i+1].number;
                           contact[i].address := contact[i+1].address;
                      END;
                      item := item - 1;
                      writeln('Delete DONE');
                 END;
             showMessage;
        END;

        PROCEDURE quit;
        BEGIN
             HALT(0);
        END;

        PROCEDURE save;
        BEGIN
             ASSIGN(contactFile, 'savedContact.txt');
             REWRITE(contactFile);
             FOR i:= 1 TO item-1 DO
             BEGIN
                 writeln(contactFile, contact[i].name);
                 writeln(contactFile, contact[i].family);
                 writeln(contactFile, contact[i].code);
                 writeln(contactFile, contact[i].number);
                 writeln(contactFile, contact[i].address);
             END;
             close(contactFile);
             showMessage;
        END;

        PROCEDURE load;
        BEGIN
             ASSIGN(contactFile, 'savedContact.txt');
             RESET(contactFile);
             {FOR i:=1 TO n DO}
             while NOT EOF(contactFile) DO
             BEGIN
                  readln(contactFile, contact[item].name);
                  readln(contactFile, contact[item].family);
                  readln(contactFile, contact[item].code);
                  readln(contactFile, contact[item].number);
                  readln(contactFile, contact[item].address);
                  item := item + 1;
             END;
             close(contactFile);
             showMessage;
        END;

        PROCEDURE showMessage;
        BEGIN
             writeln;
             writeln('1. Add Contact');
             writeln('2. Show All');
             writeln('3. Search');
             writeln('4. Sort');
             writeln('5. Edit Contact');
             writeln('6. Delete Contact');
             writeln('7. Save Contact In File');
             writeln('8. Load Contact From File');
             writeln('9. Quit');
             writeln;
             writeln('Enter Your Choise : ');
             readln(input);
             CASE input OF
                  1 : addContact;
                  2 : showAll;
                  3 : search;
                  4 : sort;
                  5 : editContact;
                  6 : deleteContact;
                  7 : save;
                  8 : load;
                  9 : quit;
                  OTHERWISE  showMessage;
             END;
        END;
BEGIN
     item := 1;
     showMessage;
END.
