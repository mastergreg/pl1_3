/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGeneratorBigInteger.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Mon 01 Aug 2011 08:28:51 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;
import java.math.BigInteger;


public class ProgramsGenerator
{
  private int minLim=0;
  private LinkedList<BigInteger> ProgList = null;
  private LinkedList<BigInteger> StartList = null;
  private BigInteger one = null;
  private BigInteger two = null;

  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    one = new BigInteger("1");
    two = new BigInteger("2");
    ProgList = new LinkedList<BigInteger>();
  }
  public void fillProgList()
  {
    StartList = new LinkedList<BigInteger>();
    StartList.add(new BigInteger("0"));
    StartList.add(new BigInteger("1"));
    ProgList=StartList;
    
    //ProgList.add("");
    //for(int i=0;i<minLim;i++)
    //{
    //  makeMoreProgs();
    //}
  }
  public void makeMoreProgs()
  {
    //LinkedList<String> StartList;
    StartList = new LinkedList<BigInteger>();
    for(BigInteger S : ProgList)
    {
      StartList.add((S.shiftLeft(1)));
      StartList.add(S.shiftLeft(1).add(BigInteger.ONE));
    }
    ProgList=StartList;
  }
  public void setProgList(LinkedList<BigInteger> newPLst)
  {
    ProgList=newPLst;
  }
  public LinkedList<BigInteger> getProgList()
  {
    return ProgList;
  }
  public void printProgs()
  {
    for(BigInteger S : ProgList)
    {
      System.out.println(S);
    }
  }
}

