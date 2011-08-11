/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Thu 11 Aug 2011 07:27:04 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.ArrayList;


public class ProgramsGenerator
{
  private int minLim=0;
  private ArrayList<Program> ProgList = null;
  private ArrayList<Program> StartList = null;

  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new ArrayList<Program>();
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
    StartList=new ArrayList<Program>();
    for(Program S : ProgList)
    {
      Program BuffA = S.clone();
      Program BuffM = S.clone();
      BuffA.add('A');
      BuffM.add('M');
      StartList.add(BuffA);
      StartList.add(BuffM);
    }
    ProgList=StartList;
  }
  public void setProgList(ArrayList<Program> newPLst)
  {
    ProgList=newPLst;
  }
  public ArrayList<Program> getProgList()
  {
    return ProgList;
  }
  public void printProgs()
  {
    for(Program S : ProgList)
    {
      System.out.println(S);
    }
  }
}

