package com.celci2015.CLI;

import com.celci2015.UserInterface;

import java.util.Scanner;

/**
 * Created by pablo on 07/09/15.
 */
public class Cli extends UserInterface{



    private final Scanner reader;

    public Cli() {
        reader = new Scanner(System.in);
        while(true)
        {
            String input = reader.nextLine();
            if (!input.matches(expressionPattern))
            {
                System.out.println(BAD_INPUT);
                continue;

            }
            else System.out.println(query(input));
        }
    }

    @Override
    public void display(String result) {

    }

}
