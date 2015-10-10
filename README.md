# COMP2526-Java-Assignment-1a

Comp 2526 Assignment #1a

--------------------------------------------------------------------------------------------
Description: 

You are to develop a program that prints out the multiplication or addition table 
given the users start and end range and type of table. The program will make use 
of 2D arrays to calculate the table. The program will make use of the System.out.printf() 
method to allow formatted output. The program will have TWO methods with the following 

    name and signature: public void createTable(int begin, int finish, TableType tableType)

    public void printTable()

An additional method to check on arguments passed in to main will be provided 
(called argumentCheck()). This method will return true if the arguments passed in are 
valid and will set the data members: start, end and tableType.

There is no constructor, nor any other method (including overloaded methods).

The class will contain a data member (handle) for the table (a 2D array of type float), 
start and end (ints) for the start and end values of the table, and tableType (TableType) 
an enumerated type consisting of {MULT, ADD}.

Assume a spacing of 5 for numbers in the table when printing {e.g. 1 is printed as 
“<sp><sp><sp><sp>1”, 234 is printed as “<sp><sp>234”}

You will be required to create an enumerated type “TableType” as a private member.

The class will be called ArithmeticTable

Execute the example program for details. The program takes in the start, end and table type 
(‘*’ or ‘+’). Default is ‘*’ and default size is start=1, end=10. Order of arguments passed 
is the same as the method createTable().
