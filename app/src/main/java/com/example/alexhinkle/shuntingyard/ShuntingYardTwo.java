package com.example.alexhinkle.shuntingyard;

import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by AlexHinkle on 4/19/16.
 */
public class ShuntingYardTwo extends shuntingYard {

    private LinkedList<String> outputQ = new LinkedList<String>();
    private LinkedList<String> inputQ = new LinkedList<String>();
    private Stack<String> opStack = new Stack<String>();//change


    private int opPriotity()
    {
        if(opStack.equals("+") || opStack.equals("-"))
        {
            return 2;
        }
        else if(opStack.equals("*"))
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }

    public ShuntingYardTwo(String postFix)
    {
        StringTokenizer st = new StringTokenizer(postFix, "+-*/^()", true);
        while(st.hasMoreTokens())
        {
            this.inputQ.addLast(st.nextToken().trim());
        }
    }
    private boolean isOp(String symbol)
    {
        return "+-*/^()".indexOf(symbol) >=0;
    }

    public String getAnswer()
    {
       String currSymbol;
        while(this.inputQ.size() > 0)
        {
            currSymbol = this.inputQ.removeFirst();
            if(this.isOp(currSymbol))
            {
                if(currSymbol.equals("("))
                {
                    this.opStack.push(currSymbol);

                }
                else if(currSymbol.equals(")"))
                {
                    String currOp;
                    while (!this.opStack.empty())
                    {
                        currOp = this.opStack.pop();
                        if(currOp.equals("("))
                        {
                            break;
                        }
                        else
                        {
                            this.outputQ.addLast(currOp);
                        }
                    }
                }
                else if(currSymbol.equals("^"))
                {
                    this.opStack.push(currSymbol);
                }
                else
                {
                    //must be a normal op
                    //try to add this to the op stack over and over until it finally fits.

                }
            }
        }
        return "";
    }
}
