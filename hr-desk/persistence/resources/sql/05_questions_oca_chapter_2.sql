--1
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (44, 'Which of the following Java operators can be used with boolean variables?',
                       '(Choose all that apply)',
                       '==', '+', '--', '!', '%', '<=',
                       true, false, false, true, false, false,
                       'A, D. Option A is the equality operator and can be used on numeric primitives, bool-
ean values, and object references. Options B and C are both arithmetic operators and
cannot be applied to a boolean value. Option D is the logical complement operator
and is used exclusively with boolean values. Option E is the modulus operator, which
can only be used with numeric primitives. Finally, option F is a relational operator that
compares the values of two numbers.');
--2
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (45, 'What data type (or types) will allow the following code snippet to compile? (Choose all that apply)',
                       'byte x = 5;
						byte y = 10;
						_____ z = x + y;',
                       'int', 'long', 'boolean', 'double', 'short', 'byte',
                       true, true, false, true, false, false,
                       'A, B, D. The value x + y is automatically promoted to int , so int and data types that
can be promoted automatically from int will work. Options A, B, D are such data
types. Option C will not work because boolean is not a numeric data type. Options E
and F will not work without an explicit cast to a smaller data type.');
--3
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (46, 'What is the output of the following application?',              
'1: public class CompareValues {
 2:        public static void main(String[] args) {
 3:            int x = 0;
 4:            while(x++ < 10) {}
 5:            String message = x > 10 ? "Greater than" : false;
 6:            System.out.println(message+","+x);
 7:        }
 8:}',
                       'Greater than,10', 'false,10', 'Greater than,11', 'false,11', 'The code will not compile because of line 4.', 'The code will not compile because of line 5.',
                       false, false, false, false, false, true,
                       'F. In this example, the ternary operator has two expressions, one of them a String and
the other a boolean value. The ternary operator is permitted to have expressions that
don’t have matching types, but the key here is the assignment to the String reference.
The compiler knows how to assign the first expression value as a String , but the sec-
ond boolean expression cannot be set as a String ; therefore, this line will not compile.');
--4
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (47, 'What change would allow the following code snippet to compile? (Choose all that apply)'              
'3: long x = 10;
4: int y = 2 * x;',
                       'No change; it compiles as is.', 'Cast x on line 4 to int.', 'Change the data type of x on line 3 to short.', 'Cast 2 * x on line 4 to int.', 'Change the data type of y on line 4 to short.', 'Change the data type of y on line 4 to long.',
                       false, true, true, true, false, true,
                       'B, C, D, F. The code will not compile as is, so option A is not correct. The value 2 * x
is automatically promoted to long and cannot be automatically stored in y , which is
in an int value. Options B, C, and D solve this problem by reducing the long value to
int . Option E does not solve the problem and actually makes it worse by attempting
to place the value in a smaller data type. Option F solves the problem by increasing the
data type of the assignment so that long is allowed.');
--5
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (48, 'What is the output of the following code snippet?',
'3: java.util.List<Integer> list = new java.util.ArrayList<Integer>();
 4: list.add(10);
 5: list.add(14);
 6: for(int x : list) {
 7: System.out.print(x + ", ");
 8: break;
 9: }',
                       '10, 14,', '10, 14', '10,', 'The code will not compile because of line 7.', 'The code will not compile because of line 8.', 'The code contains an infinite loop and does not terminate.',
                       false, false, true, false, false, false,
                       'C. This code does not contain any compilation errors or an infinite loop, so options D,
E, and F are incorrect. The break statement on line 8 causes the loop to execute once
and finish, so option C is the correct answer.');
--6










