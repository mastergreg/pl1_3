/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 06 Jul 2011 12:40:58 AM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class ProgramsGenerator
{
  int minLim=0;
  LinkedList<String> ProgList = null;


  ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new LinkedList<String>();
  }
  void fillProgList()
  {
    ProgList.add("A");
    ProgList.add("M");
    for(int i=0;i<minLim;i++)
    {
      makeMoreProgs();
    }
  }
  void makeMoreProgs()
  {
    LinkedList<String> StartList;
    StartList = new LinkedList<String>();
    for(String S : ProgList)
    {
      StartList.add(S+"A");
      StartList.add(S+"M");
    }
    ProgList=StartList;
  }
  LinkedList<String> getProgList()
  {
    return ProgList;
  }
  void printProgs()
  {
    for(String S : ProgList)
    {
      System.out.println(S);
    }
  }
}

