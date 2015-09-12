# COSTA RICA INSTITUTE OF TECHNOLOGY

- **Computer Engineering**

- **Programming Languages, Compilers and Interpreters**

- **Polynomial Calculator**

- **Project by: Roberto Bonilla and Pablo Rodríguez**








##Introduction

Nowadays, it's common to use polynoms in every area. Math is everywhere, and calculators helps to get correct results easier. But the calculators does not appear from nothing, an engineer has to do them. One of the options is the Object Oriented Paradigm, because the object abstraction makes easier the data structure management and the modular programming.

##Problem description

To develop a polynomial calculator, using Object Oriented Paradigm, that allows to perform mathematical operations on a friendly environment. It has to be able to add, substract and multiply two polynoms of two variables of any order.

##User guide

You need to have installed Java 1.7 in order to run the program.
- To run the user interface, excecute the following command:
![Command](http://s14.postimg.org/qdz4teycx/cmd.png)
- To insert a polynom with N terms, use the following sintax:

  P(x,y) = coefficient<sub>0</sub> Order(x)<sub>0</sub> Order(y)<sub>0</sub> | ... | coefficient<sub>N-1</sub> Order(x)<sub>N-1</sub> Order(y)<sub>N-1</sub>

- You can add pressing "+".

- You can sustract pressing "(-)".

- You can multiply pressing "*".

- You can evaluate pressing "e".

- You can delete all pressing "D".

- You can delete text pressing "C".

##Development envioronment

- GNU nano 2.2.6
- LX Terminal
- Java 1.7
- Intellij IDEA
- GitHub

##Program design

-Addition: reicieves two polynoms and adds the coefficient of the terms with the same order on the two variables.

![Add0](http://s1.postimg.org/vlne85wrj/Screenshot_from_2015_09_11_23_42_03.png)
![Add1](http://s11.postimg.org/85k22iolf/Screenshot_from_2015_09_11_23_42_30.png)
![Add2](http://s22.postimg.org/nqed22569/Screenshot_from_2015_09_11_23_42_48.png)
-Reduction: reicieves a polynom and applies an addition to it's terms, in other words, returns the polynom without terms presenting the same order.
Substraction: reicieves two polynoms and substract the coefficient of the terms with the same order. The first polynom is minuend the and the second the subtrahend.

-Multiplication: reicieves two polynoms, multiplies every term of the first with every term of the second and reducts the result. To multiply two terms, the coefficient is multiplied and the orders of the same variables is added.

-Evaluation: reicives a polynom and the value of it's two variables and performs the operation to get the scalar result of the expression.

##Project final status

The requirements has been performed successfully.

##Conclusions

- The Object Oriented Paradigm increases the productivity of the programmer.
- The Object Oriented Paradigm provides tools to generate abstract, undestandable, modular, polymorphic and reusable.
- To solve mathematical problems with programming languages increases the knowledge.
- The Object Oriented Paradigm could slower because there is a tendency to spend more memory. 

##Suggestions and recommendations

-Use Regular Expressions to evaluate syntax.

## Student's Activity Log

Chart 1. Roberto Bonilla's timesheet.

| Activity                    | Time(h) |
|:---------------------------:|:-------:|
| Planning                    |    2h   |
| Writing code                |    4h   |
| Writing documentation       |    4h   |

Chart 2. Pablo Rodriguez's timesheet.

| Activity                    | Time(h) | Description |
|:---------------------------:|:-------:|:-----------:|
| Planning                    |    2h   | Meeting with Roberto |
| Writing code                |    5h   | Making Math Expression Class and the Gui Form |
| Writing code                |    1h   | Debugging |
| Writing documentation       |    2h   | Internal Documentation and External |

## References
* "Program: Implement Quick Sort in Java." Implement Quick Sort in Java. N.p., n.d. Web. 12 Sept. 2015.  http://java2novice.com/java-sorting-algorithms/quick-sort/
* "How to Concatenate Two Integers in Java." Math. N.p., n.d. Web. 12 Sept. 2015.  http://stackoverflow.com/questions/12700497/how-to-concatenate-two-integers-in-c
