insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (1, 'Which of the following are valid Java identifiers?',
                       '(Choose all that apply)',
                       'A$B', '_helloWorld', 'true', 'java.lang', 'Public', '1980_s',
                       true, true, false, false, true, false,
                       'A, B, E. Option A is valid because you can use the dollar sign in identifiers. Option B is
valid because you can use an underscore in identifiers. Option C is not a valid identifier
because true is a Java reserved word. Option D is not valid because the dot (.) is not
allowed in identifiers. Option E is valid because Java is case sensitive, so Public is not
a reserved word and therefore a valid identifier. Option F is not valid because the first
character is not a letter, $, or _.');

insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf,ansg, cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer) 
               VALUES (2, 'Which of the following are true?',
                       '(Choose all that apply)',
                       'A local variable of type boolean defaults to null.', 'A local variable of type float defaults to 0.', 'A local variable of type Object defaults to null.', 'A local variable of type boolean defaults to false.', 'A local variable of type boolean defaults to true.', 'A local variable of type float defaults to 0.0', 'None of the above.',  
                       false, false, false, false, false, false, true,
                       ' G. Option G is correct because local variables do not get assigned default values. The code fails to compile if a local variable is not explicitly initialized. If this question were about instance variables, options D and F would be correct. A boolean primitive defaults to false and a float primitive defaults to 0.0. ');
                       
                       
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, cansa, cansb, cansc, cansd, canse, cansf ,cansg, full_answer) 
               VALUES (3, 'Which of the following legally fill in the blank so you can tun the main() method from the command line?',
                       '(Choose all that apply)',
                       'String[] _names', 'String[] 123', 'String abc[]', 'String _Names[]', 'String.. $n', 'String names', 'None of the above',
                       false, false, false, false, true, false, false,
                       'E. Option E is the canonical main() method signature. You need to memorize it.
Option A is incorrect because the main() method must be public. Options B and F
are incorrect because the main() method must have a void return type. Option C is
incorrect because the main() method must be static. Option D is incorrect because the
main() method must be named main.');
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer)
values (4, 'Which of the following are legal entry point methods that can be run from the command line?','(Choose all that apply)','private static void main(String[] args)','public static final main(String[] args)',
'public void main(String[] args)','public static void test(String[] args)','public static void main(String[] args)','public static main(String[] args)','None of the above.',false,false,false,false,true,false,false,
'Option E is the canonical main() method signature. You need to memorize it. Option A is incorrect because the main() method must be public. Options B and F
are incorrect because the main() method must have a void return type. Option C is incorrect because the main() method must be static. Option D is incorrect because the main() method must be named main.'
);
insert into questions (id ,label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
VALUES (5, 'Gived the following classes, what is the maximum number of imports that can be removed
       and have the code still compile?',
       'package aquarium;
       import java.lang.*;
       import java.lang.System;
       import aquarium.Water;
       import aquarium.*;
       public class Tank{
       	public void print(Water water){
       	  System.out.println(water);
       	  }}',	  
       '0', '1', '2', '3', '4', 'Does not compile.',
       false, false, false, false, true, false,
       'E. The first two imports can be removed because java.lang is automatically imported. 
       The second two imports can be removed because Tank and Water are in the same 
       package, making the correct answer E. If Tank and Water were in different packages, one of 
       these two imports could be removed. In that case, the answer would be option D. ');


insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer) 
               VALUES (6, 'Given the following class, which of the following calls print out Blue Jay?',
                       '(Choose all that apply)	
                       	public class BirdDisplay { 
                       		public static void main(String[] name) {
                       			System.out.println(name[1]);
                       	} }',
                       'java BirdDisplay Sparrow Blue Jay', 'java BirdDisplay Sparrow "Blue Jay"', 
                       'java BirdDisplay Blue Jay Sparrow', 'java BirdDisplay "Blue Jay" Sparrow',
                       'java BirdDisplay.class Sparrow "Blue Jay" ', 'java BirdDisplay.class "Blue Jay" Sparrow', 'Does not compile.',
                       false, true, false, false, false, false, false,
                       'B. Option B is correct because arrays start counting from zero and strings with spaces
must be in quotes. Option A is incorrect because it outputs Blue. C is incorrect because
it outputs Jay. Option D is incorrect because it outputs Sparrow. Options E and F are
incorrect because they output Error: Could not find or load main class BirdDisplay.class');

insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, cansa, cansb, cansc, cansd, canse, full_answer) 
               VALUES (7, 'Given the following class, which of the following is true? (Choose all that apply)',
'1: Public class Snake { 
 2:  
 3:     public void shed(boolean time) { 
 4:  
 5:         if(time){ 
 6:  
 7:         }  
 8:         System.out.println(result);  
 9:  
 10:    } 
 11: }',
 'If String result = "done"; is inserted on line 2, the code will compile.', 'If String result = "done"; is inserted on line 4, the code will compile.', 'If String result = "done"; is inserted on line 6, the code will compile.', 'If String result = "done"; is inserted on line 9, the code will compile.', 'None of the above changes will make the code compile',true, true, false, false, false, 
 'A, B. Adding the variable at line 2 makes result an instance variable.
Since instance variables are in scope for the entire life of the object, option A is correct.
Option B is correct because adding the variable at line 4 makes result a local variable with a scope of the whole method.
Adding the variable at line 6 makes result a local variable with a scope of lines 6–7. Since it is out of scope on line 8, the println does not compile and option C is incorrect.
Adding the variable at line 9 makes result a local variable with a scope of lines 9 and 10. Since line 8 is before the declaration, it does not compile and option D is incorrect.
Finally, option E is incorrect because the code can be made to compile. ');


insert into questions (id, label, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf,cansg, full_answer) 
               VALUES (8, 'Which of the following are true?','an istance variable of type doubledefaults to null','an istance variable of type int defaults to null,''an istance variable type String defaults to null','an istance variable of type double default to 0.0','an istance variable of type int defaults 0.0','an istance variable of type String default to 0.0','none of the above',false,false,true,true,false,false,false, ' Option C is correct because all non-primitive values default to null Option D is correct because float and double primitives default to 0.0. Options B and E are incorrect because int primitives default to 0.'
               );
               
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer)
values (9, 'Given the following classes, wich of the following snippets can be inserted in place of INSERT IMPORTS HERE and have the code compile? (Choose all apply)',
	'package acquarium;
	public class Water{
	boolean salty = false;
	}
	package acquarium.jellies;
	public class Water{
	boolean salty = true;
	}
	package employee;
	INSERT IMPORTS HERE
	public class WaterFiller {
	Water water;
	}',
	'import acqiarium.*;',
	'import acquarium.Water;
	 import acquarium.jellies.*;',
     'import acquarium.*;
	 import acquarium.jellies.Water;',
	'import acquarium.*;
	 import acquarium.jellies.*;',
	 'import acquarium.Water;
	  import aquarium.jellies.Water;',
	 'Non of these imports can make the code compile.',
	 true,
	 true,
	 true,
	 false,
	 false,
	 false,
	 'A, B, C.
	 Option A is correct because it imports all the classes in the aquarium package including aquarium.Water.
      Options B and C are correct because they import Water by classname. Since importing by classname takes precedence over wildcards, these compile. 
      Option D is incorrect because Java doesn’t know which of the two wildcard Water classes to use. 
      Option E is incorrect because you cannot specify the same classname in two imports.'
      );
      
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (10, "What is the output of the following program?",'1: public class WaterBottle { 
2: private String brand; 
3: private boolean empty; 
4: public static void main(String[]args){ 
5: WaterBottle wb = new WaterBottle(); 
6: System.out.print("Empty = " + wb.empty); 
7: System.out.print(", Brand = " + wb.brand); 
8: } }',
	"A. Line 6 generates a compiler error.",
	"B. Line 7 generates a compiler error.",
	"C. There is no output.",
	"D. Empty = false, Brand = null",
	"E. Empty = false, Brand =",	
	"F. Empty = null, Brand =null",
	false,false,false,true,false,false,
	"D. Boolean fields initialize to false and references initialize to null, so empty is false and brand is null. Brand = null is output.");
	
insert into questions (id, label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer)
	values (11, "Which of the following are true?","(Choose all that apply)",
		"line 4 generates a compiler error","line 5 generates a compiler error","line 6 generates a compiler error","line 7 generates a compiler error","line 8 generates a compiler error","line 9 generates a compiler error","the code compiles as is",
		false,true,false,true,true,false,false,
		"B, D, E. Option A (line 4) compiles because short is an integral type. Option B (line 5) generates a compiler error because int is an integral type, but 5.6 is a floating-point type. Option C (line 6) compiles because it is assigned a String. Options D and E (lines 7 and 8) do not compile because short and int are primitives. Primitives do not allow methods to be called on them. Option F (line 9) compiles because length() is defined on String.");

insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse, ansf,cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (12,'Given the following classes, which of the following can independently replace INSERT IMPORTS HERE to make the code compile? (Choose the apply)',
                       'pachage acquarium, 
                       public class Tank, 
                       package aquarium.jellies;
                       public class Jelly {}
                       package visitor;
                       INSERT IMPORTS HERE
                       public class AquariumVisitor {
                         public void admire (Jelly jelly) {}}', 'Import aquarium.*;', 'import aquarium.*Jelly;','import aquarium.jellies.Jelly;','import aquarium.jellies.*;','import aquarium.jellies.Jelly.*;','None of these can make the code compile.',
                         false, false, true, true, false, false, 'Option C si correct because it imports Jelly by classname. Option D is correct because it imports all the classes in the jellies package, which includes Jelly. Option A is incorrect those in lower-level packages, Option B is incorrect because you cannot use wildcards anyplace other than the end of an import statment. Opion E is incorrect because you cannot import parts of a class with a regular import statement. Option F is incorrect because option C and D do make the code compile.');
    
insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg,cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer) 
               VALUES (13,'Which of the following are valid java variable declarations?','(Choose the apply)',
                       'String txt ;', 'Integer $1 ;','Boolean _a ;','int Pub ;','Object b_ ;','char a3 ;','None of listed above are valid.',
                         true, true, true, true, true, false, false, 'There are only three rules to remember for legal identifiers:
- The name must begin with a letter or the symbol $ or _.
- Subsequent characters may also be numbers(beyond that letters, $ and _ character).
- You cannot use the same name as a Java reserved word.');
                         
insert into surveys(id, label, time, description) values (1, 'Questionario Java cap. 1', 20, 'Questionario Java OCA Capitolo 1');
insert into surveys(id, label, time, description) values (2, 'Questionario Java cap. 2', 20, 'Questionario Java OCA Capitolo 2');
insert into surveys(id, label, time, description) values (3, 'Questionario candidati corso Java+Web', 20, 'Questionario di valutazione per candidati corso Full Stack Develpment Java+Web');
insert into surveys(id, label, time, description) values (4, 'Questionario candidati corso Java+Web 2', 20, 'Questionario di valutazione per candidati corso Full Stack Develpment Java+Web - contiene le stesse domande del questionario full stack java n.1 ma in ordine differente');
insert into surveys(id, label, description, time) values (5, "Intervista per dipendenti/consulenti it", "Intervista per dipendenti/consulenti it", 30);
insert into surveys(id, label, time, description) values (6, 'Questionario Java cap. 3', 20, 'Questionario Java OCA Capitolo 3');


insert into surveyquestions(survey_id, question_id, position) values (1,3,2);
insert into surveyquestions(survey_id, question_id, position) values (1,11,3);
insert into surveyquestions(survey_id, question_id, position) values (1,7,4);
insert into surveyquestions(survey_id, question_id, position) values (1,12,5);
insert into surveyquestions(survey_id, question_id, position) values (1,5,6);
insert into surveyquestions(survey_id, question_id, position) values (1,9,7);
insert into surveyquestions(survey_id, question_id, position) values (1,8,11);
insert into surveyquestions(survey_id, question_id, position) values (1,4,10);
insert into surveyquestions(survey_id, question_id, position) values (1,2,12);

insert into surveyquestions(survey_id, question_id, position) values (3,13,1);

insert into surveyquestions(survey_id, question_id, position) values (4,13,10);






insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg, ansh, cansa, cansb, cansc, cansd, canse, cansf, cansg, cansh, full_answer) 
               VALUES (14,'Which of the following are valid http verbs?','(Choose the apply)',
                        'GET', 'STOP', 'PICK', 'PUT','PATCH', 'DELETE', 'All of listed above are valid.','NNone of listed above are valid.',
                         true,  false,  false,  true,   true,    true,                       false, 						false,
                       'The primary or most-commonly-used HTTP verbs (or methods, as they are properly called) 
                       are POST, GET, PUT, PATCH, and DELETE. These correspond to create, read, update, and delete (or CRUD) operations, respectively. 
					   There are a number of other verbs, too, but are utilized less frequently.');

insert into surveyquestions(survey_id, question_id, position) values (3,14,2);
insert into surveyquestions(survey_id, question_id, position) values (4,14,9);

insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse, ansf, ansg,cansa, cansb, cansc, cansd, canse, cansf, cansg, full_answer) 
               VALUES (15,'What does means sql?','(Choose the apply)',
                       'Start Query Language', 'Simple Query Loading', 'Structured Query Language', 'Simple Query Language', 'Sequel Query Language', 'All of listed above are valid.','None of listed above are valid.',
                         				false,  				false,  					true,  				  false,                   false,                      false,                      false,    
                       'SQL stands for Structured Query Language. SQL is used to communicate with a database.');

insert into surveyquestions(survey_id, question_id, position) values (3,15,3);
insert into surveyquestions(survey_id, question_id, position) values (4,15,8);

insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse,cansa, cansb, cansc, cansd, canse, full_answer) 
               VALUES (16,'In Javascript which of the following are valid variable declarations?','(Choose the apply)',
                       'var person = "John Doe", carName = "Volvo", price = 200;', 'var test2;', 'var Prefix = 10;', 'All of listed above are valid.','None of listed above are valid.',
                         				   									 true,  	   true,  			   true,                       true,                      false, 
                       'The general rules for constructing names for variables, in javascript, (unique identifiers) are:
    Names can contain letters, digits, underscores, and dollar signs.
    Names must begin with a letter, with $ and _ .
    Names are case sensitive (y and Y are different variables)
    Reserved words (like JavaScript keywords) cannot be used as names.
    You can declare many variables in one statement.');

insert into surveyquestions(survey_id, question_id, position) values (3,16,4);
insert into surveyquestions(survey_id, question_id, position) values (4,16,7);


insert into questions (id,label, description, ansa, ansb, ansc, ansd, anse, ansf, cansa, cansb, cansc, cansd, canse, cansf, full_answer) 
               VALUES (17,'What does means css?','(Choose the apply)',
                       'Custom Style Selector', 'Cross Style Structure', 'Change Sleep Style', 'Cascading Style Sheets', 'All of listed above are valid.','None of listed above are valid.',
                         				false,  				  false,  				false,                     true,                      false,                      false,    
                       'CSS stands for Cascading Style Sheets. CSS is a language that describes the style of an HTML document.
                        CSS describes how HTML elements should be displayed.');

insert into surveyquestions(survey_id, question_id, position) values (3,17, 5);
insert into surveyquestions(survey_id, question_id, position) values (4,17, 6);

insert into questions (id,label, description, ansa, ansb, cansa, cansb, full_answer) 
               VALUES (18,'In Java, a class can extends another class?','(Choose only one)',
                       'yes',    'no', 
                       true,  	false,    
                       'Yes, in Java, a class can extends an other class.');

insert into surveyquestions(survey_id, question_id, position) values (3,18, 6);
insert into surveyquestions(survey_id, question_id, position) values (4,18, 5);

insert into questions (id,label, description, ansa, ansb, cansa, cansb, full_answer) 
               VALUES (19,'In Java, an interface can extends another interface?','(Choose only one)',
                       'yes',    'no', 
                       true,  	false,    
                       'Yes, in Java, an interface can extends an other interface.');

insert into surveyquestions(survey_id, question_id, position) values (3,19, 7);
insert into surveyquestions(survey_id, question_id, position) values (4,19, 4);

insert into questions (id,label, description, ansa, ansb, cansa, cansb, full_answer) 
               VALUES (20,'In Java, an abstract class can be instantiated?','(Choose only one)',
                       'yes',    'no', 
                       false,  	true,    
                       'Yes, in Java, an abstract cannot be instantiated.');

insert into surveyquestions(survey_id, question_id, position) values (3,20, 8);
insert into surveyquestions(survey_id, question_id, position) values (4,20, 3);

insert into questions (id,label, description, ansa, ansb, ansc, ansd, cansa, cansb, cansc, cansd, full_answer) 
               VALUES (21,'Which of the following polymorphism concepts are rights?','(Choose the apply)',
                       'Polymorphism allows you to implement multiple methods within the same class that use the same name but a different set of input parameters.', 
                       'Polymorphism does not allows you to implement multiple methods within the same class that use the same name and the same set of input parameters.', 
                       'Within an inheritance hierarchy, a subclass can override a method of its superclass.', 
                       'Within an inheritance hierarchy, a subclass cannot override a method of its superclass.', 
                         				true,  				  false,  				true,                     true,                       
                       'Polymorphism describes the concept that objects of different types can be accessed through the same interface.
Overload allows you to implement multiple methods within the same class that use the same name but a different set of input parameters.
Override allows you to write a method in a class and write a method with the same signature in a child class.');

insert into surveyquestions(survey_id, question_id, position) values (3,21, 9);
insert into surveyquestions(survey_id, question_id, position) values (4,21, 2);

insert into questions (id,label, description, ansa, ansb, ansc, ansd, cansa, cansb, cansc, cansd, full_answer) 
               VALUES (22,'In a relational database a primary key....','(Choose the apply)',
                       '...must contain a unique value', '...can contain duplicated values', '..can contain null values', '...uniquely identify a record', 
                         				           true,  				              false,  				       false,                            true,    
                       'A primary key is a special relational database table column (or combination of columns) designated to uniquely identify all table records.
						A primary key must contain a unique value for each row of data. It cannot contain null values.');

insert into surveyquestions(survey_id, question_id, position) values (3,22, 10);
insert into surveyquestions(survey_id, question_id, position) values (4,22, 1);

insert into interviews (id, question_text, ansa,ansb,ansc,ansd,anse,ansf,ansg,ansh) values (1, "Indica la percorrenza media per il tragitto casa - lavoro.", "< 15 minuti", "< 30 minuti", "< 45 minuti", "< 1 ora", "< 1 ora e 30 minuti", "< 2 ore", "> 2 ore", "Preferisco non rispondere");
insert into interviews (id, question_text, ansa,ansb,ansc,ansd,anse,ansf,ansg,ansh, ansi, ansj) values (2, "Indica quanto sei soddisfatto, dal punto di vista logistico del tuo attuale impiego,", "lavoro vicino casa", "lavoro mediamente vicino da casa ma sono comodo e non mi dispiace", "lavoro mediamente lontano da casa ma sono comodo e non mi dispiace", "lavoro discretamente lontano - impiego circa 1 ora con i mezzi pubblici", "lavoro discretamente lontano - impiego circa 1 ora con un mio mezzo(ed eventualmente mezzi pubblici)", "lavoro discretamente lontano - impiego circa 1,5 ore con i mezzi pubblici", "lavoro discretamente lontano - impiego circa 1,5 ore con un mio mezzo(ed eventualmente mezzi pubblici)", "lavoro discretamente lontano - impiego dalle 2 ore in su con i mezzi pubblici", "lavoro discretamente lontano - impiego dalle 2 ore in su con un mio mezzo(ed eventualmente mezzi pubblici)", "lavoro troppo lontano.");

insert into surveyinterviews (id, survey_id, interview_id, position) values (1, 5, 1, 1);
insert into surveyinterviews (id, survey_id, interview_id, position) values (2, 5, 2, 1);
