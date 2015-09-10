package com.celci2015.CLI;

import com.celci2015.UserInterface;

import java.util.Scanner;

/**
 * Created by pablo on 07/09/15.
 */
public class Cli extends UserInterface{

    public Cli(String [] args)
    {
        String input;
        input = args[0]+ " " + args[1] + " " + args[2];

            if (!input.matches(expressionPattern))
            {
                System.out.println(BAD_INPUT + "!");


            }
            else query(input);

    }

    @Override
    public void display(String result) {
        System.out.println(result);
    }

}
