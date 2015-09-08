package com.celci2015.math;

import com.celci2015.Processor;

import java.util.ArrayList;

/**
 * Created by pablo on 9/7/15.
 */
public class MathExpression {
    private ArrayList<Tuple> tuples;
    public MathExpression(String expression) throws Exception {
        tuples = Processor.convertExpression(expression);
        simplify();
    }

    public int eval(int x , int y)
    {
        int result =0;
        for (Tuple tuple :tuples) {
            result += tuple.getMultiplier() * Math.pow(x, tuple.getxExponent()) * Math.pow(y, tuple.getyExponent());
        }
        return result;
    }

    private void simplify()
    {
        if (tuples.size() == 0) return;
        quickSort(0, tuples.size() - 1);
        int i = 1;
        while (i<tuples.size())
        {
                analyzeEquals(i-1,i);
        }

    }

    private void quickSort(int lowerIndex, int higherIndex)
    {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Tuple pivot = tuples.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (tuples.get(i).getValue() < pivot.getValue()) {
                i++;
            }
            while (tuples.get(j).getValue() > pivot.getValue()) {
                j--;
            }
            if (i <= j) {
                exchangeTuples(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }

        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);

    }
    private void exchangeTuples(int i, int j) {
        if(i==j) return;
            Tuple temp = tuples.get(i);
            tuples.set(i, tuples.get(j));
            tuples.set(j, temp);

    }

    /**
     * Analyzes if two tuples have the same grade of x and y.
     * @param i position of first tuple;
     * @param j position of second tuple;
     * @return
     */
    private boolean analyzeEquals (int i, int j)
    {
        if(i==j) return true;
        if(tuples.get(i).getValue()==tuples.get(j).getValue())
        {
            Tuple temp = tuples.get(i);
            temp.setMultiplier(temp.getMultiplier() + tuples.get(j).getMultiplier());
            tuples.remove(j);
            if(temp.getMultiplier()==0)
            {
                tuples.remove(i);
            }
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String result = "";
        for (Tuple tuple :tuples) {
                result+= tuple.getMultiplier() + " " + tuple.getxExponent() + " " + tuple.getyExponent()+"|";
        }
        return result.substring(0,result.length()-1);
    }
}
