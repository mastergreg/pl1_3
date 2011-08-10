/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 10 Aug 2011 03:02:42 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class ProgramsGenerator
{
  private int minLim=0;
  private LinkedList<Program> ProgList = null;
  private LinkedList<Program> StartList = null;
  private int progLen;

  private Program BuffA = null;
  private Program BuffM = null;
  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new LinkedList<Program>();
    progLen=0;
  }
  public void fillProgList()
  {
    ProgList.add(new Program());
    for(int i=0;i<minLim;i++)
    {
      makeMoreProgs();
    }
  }
  public void makeMoreProgs()
  {
    //System.gc();
    progLen++;
    StartList=new LinkedList<Program>();
    for(Program S : ProgList)
    {
      BuffA = (Program) S.clone();
      BuffA.set(S.getMyLength());
      StartList.add(BuffA);
      BuffM = (Program) S.clone();
      BuffM.clear(S.getMyLength());
      StartList.add(BuffM);
    }
    ProgList=StartList;
  }
  public void setProgList(LinkedList<Program> newPLst)
  {
    ProgList=newPLst;
  }
  public LinkedList<Program> getProgList()
  {
    return ProgList;
  }
  public void printProgs()
  {
    for(Program S : ProgList)
    {
      System.out.println(S.toString());
    }
  }
  public void printProgsSize()
  {
    System.out.println(progLen);
  }
}

