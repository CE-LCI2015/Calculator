package com.celci2015.math;

import com.celci2015.Processor;

import java.util.ArrayList;

/**
 * Created by pablo on 9/7/15.
 * Class represented as # # # | # # # | # # # | .....
 * Each # # # is a tuple
 * For example : 1 2 3 | 4 5 6 would be a Math expression and its List of Tuple would be length 2.
 * The tuples would be 1 2 3 and 4 5 6.
 */
public class MathExpression {
    private ArrayList<Tuple> tuples;
    public MathExpression(String expression) throws Exception {
        tuples = Processor.convertExpression(expression);
        simplify();
    }
    public MathExpression(ArrayList<Tuple> tupleArrayList) throws Exception {
        tuples = tupleArrayList;
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
    /**
     * This works adding the toSum tuples to the object ones and then simplifying.
     * @param toSum tuples to sum
     */
    public void add(MathExpression toSum)
    {
        ArrayList<Tuple> tuplesToSum = toSum.getTuples();
        for (Tuple tuple : tuplesToSum)
        {
            tuples.add(tuple);
        }
        simplify();
    }
    /*
     * As adds but multiplies each tuple with -1
     */
    public void minus(MathExpression toSum)
    {
        ArrayList<Tuple> tuplesToSum = toSum.getTuples();
        for (Tuple tuple : tuplesToSum)
        {
            tuple.setMultiplier(tuple.getMultiplier() * -1);
            tuples.add(tuple);
        }
        simplify();
    }
    /**
     * With two "for"s we iterate through all the possible combinatios of tuples and multiplying and adding to
     * another list of tuples makes almost all of the work. THen we just simplify the new list of tuples.
     */
    public void times(MathExpression toMul)
    {
        ArrayList<Tuple> tuplesToMul = toMul.getTuples();
        ArrayList<Tuple> tuplesNew = new ArrayList<Tuple>();
        for (Tuple tupleMult : tuplesToMul)
        {
            for (Tuple tuple : tuples)
            {
                tuplesNew.add(new Tuple(tupleMult.getMultiplier()*tuple.getMultiplier(),
                        tupleMult.getxExponent()+tuple.getxExponent(),
                        tupleMult.getyExponent()+tuple.getyExponent()));
            }
        }
        tuples = tuplesNew;
        simplify();
    }
    /**
     * Sorts the tuples of list making that similar tuples will be next each other
     * Then we just review the sorted list looking for equal terms to add them and deleting the other.
     * If the result is 0 we remove both in analyze equals
     */
    private void simplify()
    {
        if (tuples.size() == 0) return;
        quickSort(0, tuples.size() - 1);
        int i = 1;
        while (i<tuples.size())
        {
            analyzeEquals(i-1,i);
            i++;
        }

    }
/**
 * Classical QuickSortmodified with tuples.
 */
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
            while (tuples.get(i).getValue() > pivot.getValue()) {
                i++;
            }
            while (tuples.get(j).getValue() < pivot.getValue()) {
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
    /**
     * Swap tuples
     */
    private void exchangeTuples(int i, int j) {
        if(i==j) return;
            Tuple temp = tuples.get(i);
            tuples.set(i, tuples.get(j));
            tuples.set(j, temp);

    }

    /**
     * Analyzes if two tuples have the same grade of x and y.
     * Erases the necessary tuples.
     * @param i position of first tuple;
     * @param j position of second tuple;
     * @return if they where equals
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

    public ArrayList<Tuple> getTuples() {
        return tuples;
    }
/**
 * Output to the user as String
 */
    @Override
    public String toString() {
        String result = "";
        for (Tuple tuple :tuples) {
                result+= tuple.getMultiplier() + " " + tuple.getxExponent() + " " + tuple.getyExponent()+" | ";
        }
        if (result.length()==0) return "0 0 0";
        String finalStr = result.substring(0,result.length()-3);
        return finalStr;
    }
}
