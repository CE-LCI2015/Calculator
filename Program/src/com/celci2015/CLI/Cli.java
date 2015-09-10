package com.celci2015.CLI;

import com.celci2015.UserInterface;

import java.util.Scanner;

/**
 * Created by pablo on 07/09/15.
 */
public class Cli extends UserInterface{

    public Cli(String [] args)
    {
        if(args.length!=3) display("Error: insufficient arguments");
        String input;
        input = args[0]+ " " + args[1] + " " + args[2];

            if (!input.matches(expressionPattern))
            {
                display(BAD_INPUT + " : " + input);


            }
            else query(input);

    }

    @Override
    public void display(String result) {
        System.out.println(result);
    }

}
