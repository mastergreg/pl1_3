/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Tue 02 Aug 2011 03:16:22 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class ProgramsGenerator
{
  private int minLim=0;
  private LinkedList<String> ProgList = null;
  private LinkedList<String> StartList = null;

  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new LinkedList<String>();
  }
  public void fillProgList()
  {
    ProgList.add("");
    for(int i=0;i<minLim;i++)
    {
      makeMoreProgs();
    }
  }
  public void makeMoreProgs()
  {
    StartList=new LinkedList<String>();
    for(String S : ProgList)
    {
      StartList.add(S+"A");
      StartList.add(S+"M");
    }
    ProgList=StartList;
  }
  public void setProgList(LinkedList<String> newPLst)
  {
    ProgList=newPLst;
  }
  public LinkedList<String> getProgList()
  {
    return ProgList;
  }
  public void printProgs()
  {
    for(String S : ProgList)
    {
      System.out.println(S);
    }
  }
}

