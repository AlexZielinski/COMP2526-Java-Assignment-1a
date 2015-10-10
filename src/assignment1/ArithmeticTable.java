package assignment1;
/*
 * Program that creates an arithmatic table. Takes in three command-line
 * arguments. First argument specifies if table is a multiplication table or an 
 * addition table. Second argument specifies what value the arithmatic table
 * will start at and the third argument specifies what value the arithmetic 
 * table will end at.
 */

/**
 * @author Alex Zielinski
 */
public class ArithmeticTable
{
 
    private static enum TableType   // enum type to determine argument
    {
        ADD, MULT
    };
    private TableType tableType;    // instance of TableType
    private String operator;        // stores math operator
    private float[][] table;        // array list for arithmetic table
    private int start;              // stores start value of table
    private int end;                // stores end value of table
    private int arraySize;          // stores array size

    public boolean argumentCheck(String[] args)
    {
        if(args.length!=3)
        {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, \"*\"");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }        

        if(args[0].charAt(0) == '+')
            tableType = TableType.ADD;
        else
            tableType = TableType.MULT;
    
        int sta;
        int sto;

        try
        {
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        }
        catch(NumberFormatException ex)
        {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if((sta < 1 || sta > 100)||((sto < 1 || sto > 100)))
        {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }

        if(sta >= sto)
        {
            System.err.println("Usage: Main <type> <start> <stop>");
            System.err.println("\tWhere <type> is one of +, -, \"*\", /");
            System.err.println("\tand <start> is between 1 and 100");
            System.err.println("\tand <stop> is between 1 and 100");
            System.err.println("\tand start < stop");
            return false;
        }
        
        start = sta;
        end = sto;
        return true;
    }

    // main method
    public static void main(String[] args)
    {
        ArithmeticTable table = new ArithmeticTable();
        if (table.argumentCheck(args))
        {
            table.createTable(table.start, table.end, table.tableType);
            table.printTable();
        }
    }

    // creates arithmatic table
    public void createTable(int begin, int finish, TableType tableType)
    {
        arraySize = end - start + 1;    // defines array size
        table = new float[arraySize][arraySize];    // creates array
        start = begin;
        end = finish;

        // determines tabletype based on first command-line argument
        switch (tableType)
        { 
            case ADD: // if + is argument value, creates addition table
                for (int row = 0; row < table.length; row++)
                    for (int col = 0; col < table.length; col++)
                        table[row][col] = (row + start) + (col + start);
            break;
     
            case MULT: // if * is argument value, creates multiplication table
                for (int row = 0; row < table.length; row++)
                    for (int col = 0; col < table.length; col++)
                        table[row][col] = (row + start) * (col + start);
            break;
        }
    }

    // prints arithmatic table
    public void printTable()
    {
        String s = "----";
        System.out.printf("\n");
        
        // determines which operator is used and prints it
        if (tableType == TableType.ADD)
            operator = "+";
        else
            operator = "*";
        System.out.printf("%4s", operator);

        // prints header numbers
        System.out.printf("  ");
        for (int i = 0; i < table.length; i++)
            System.out.printf("%4d", (i + start));

        System.out.printf("\n");

        // prints underline under header numbers
        System.out.printf("  ");
        for (int i = 0; i <= table.length; i++)
            System.out.printf("%4s", s);

        System.out.printf("\n");

        // prints side column numbers and elements of array
        for (int row = 0; row < table.length; row++)
        {
            System.out.printf("%4d |", row + start);
            for (int col = 0; col < table.length; col++)
                System.out.printf("%4.0f", table[row][col]);
            
            System.out.printf("\n");
        }
    }
}
