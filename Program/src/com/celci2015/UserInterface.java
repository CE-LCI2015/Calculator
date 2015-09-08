package com.celci2015;

import com.celci2015.math.MathExpression;

/**
 * Created by pablo on 9/7/15.
 */
public abstract class UserInterface {

    public static final String OPERATION = "\\ ([+*-]|[e])\\ ";
    public static final String expressionPattern = "(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\|(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*\\ (([+*-]\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\|(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*)|([e]\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)))";
    public static final String BAD_INPUT = "Bad input!";

    public abstract void display(String result);
    public String query(String queryString)
    {
        String[] inputs = queryString.split(OPERATION);
        try{
        switch (queryString.charAt(inputs[0].length() + 1)) {// get operation
            case '*':
                break;
            case '+':
                MathExpression expression = new MathExpression(inputs[0]);
                expression.add(new MathExpression(inputs[1]));
                return expression.toString();
            case '-':
                break;
            case 'e':
                String[] xy = inputs[1].split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                return (new MathExpression(inputs[0]).eval(x,y) +" 0 0");
            default:
                throw new Exception("Wrong Operation");
        }}
        catch(Exception e)
        {
            return (BAD_INPUT +" "+ e.getMessage());
        }
        return "";
    }
}
