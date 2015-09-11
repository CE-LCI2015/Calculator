package com.celci2015;

import com.celci2015.math.MathExpression;

/**
 * Created by pablo on 9/7/15.
 */
public abstract class UserInterface {

    public static final String OPERATION = "\\ ([+*-]|[e])\\ ";
    //Pattern this form : # # # | # # # | .... operation # # # | # # # .... where operation can be *,+,- or e.
    public static final String expressionPattern = "(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\ \\|\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*\\ (([+*-]\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\ \\|\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*)|([e]\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)))";
    public static final String BAD_INPUT = "Bad input!";

    public abstract void display(String result);
    public void query(String queryString)
    {
        if (!queryString.matches(expressionPattern)) {// Verify expression 
            if (queryString.matches(Processor.expressionPattern))// verify is its a single expression
            {
                display(queryString);
              return;
            }
            display(BAD_INPUT);
            return;
        }
        String[] inputs = queryString.split(OPERATION);
        MathExpression expression;
        try{
            //First we get the operation, then parse a math expression and then execute the other expression
        switch (queryString.charAt(inputs[0].length() + 1)) {// get operation
            case '*':
                expression = new MathExpression(inputs[0]);
                expression.times(new MathExpression(inputs[1]));
                display(expression.toString());
                break;
            case '+':
                expression = new MathExpression(inputs[0]);
                expression.add(new MathExpression(inputs[1]));
                display(expression.toString());
                break;
            case '-':
                expression = new MathExpression(inputs[0]);
                expression.minus(new MathExpression(inputs[1]));
                display(expression.toString());
                break;
            case 'e':
                String[] xy = inputs[1].split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                display(new MathExpression(inputs[0]).eval(x,y) +" 0 0");
                break;
            default:
                throw new Exception("Wrong Operation");
        }}
        catch(Exception e)
        {
            //e.printStackTrace();
            display(BAD_INPUT +" "+ e.getMessage());// Display error messagee

        }
    }
}
