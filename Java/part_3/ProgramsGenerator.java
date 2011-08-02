/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Tue 02 Aug 2011 07:19:36 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class ProgramsGenerator
{
  private int minLim=0;
  private LinkedList<Program> ProgList = null;
  private LinkedList<Program> StartList = null;

  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new LinkedList<Program>();
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
    StartList=new LinkedList<Program>();
    for(Program S : ProgList)
    {
      StartList.add(S.addA());
      StartList.add(S.addM());
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
}

