package com.celci2015;

import com.celci2015.math.Tuple;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pablo on 9/7/15.
 */
public class Processor {

    public static final String expressionPattern = "(-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)(\\ \\|\\ (-\\d+|\\d+)\\ (-\\d+|\\d+)\\ (-\\d+|\\d+))*";
    /**
     * Separate string and convert it to a Class Math Expression
     * Iterating through the splited strings and creating tuples
     * @param exp the string from the user interface
     * @return
     */
    public static ArrayList<Tuple> convertExpression(String exp) throws Exception {
        if (!exp.matches(expressionPattern)) throw new Exception("WRONG EXPRESSION PATTERN");
        ArrayList<Tuple> result = new ArrayList<Tuple>();
        for (String s :  exp.split("\\|")){
            if (s.charAt(0)==' ') s = s.substring(1);
            String[] numbers = s.split(" ");
            Tuple tuple = new Tuple(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]),Integer.parseInt(numbers[2]));
            result.add(tuple);
        }
        return result;
    }
}
