/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : ProgramsGenerator.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 03 Aug 2011 01:06:12 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class ProgramsGenerator
{
  private int minLim=0;
  private LinkedList<MBitSet> ProgList = null;
  private LinkedList<MBitSet> StartList = null;
  private int progLen;

  private MBitSet BuffA = null;
  private MBitSet BuffM = null;
  public ProgramsGenerator(int minLim)
  {
    this.minLim=minLim;
    ProgList = new LinkedList<MBitSet>();
    progLen=0;
  }
  public void fillProgList()
  {
    ProgList.add(new MBitSet());
    for(int i=0;i<minLim;i++)
    {
      makeMoreProgs();
    }
  }
  public void makeMoreProgs()
  {
    //System.gc();
    progLen++;
    StartList=new LinkedList<MBitSet>();
    for(MBitSet S : ProgList)
    {
      BuffA = (MBitSet) S.clone();
      BuffA.set(S.getMyLength());
      StartList.add(BuffA);
      BuffM = (MBitSet) S.clone();
      BuffM.clear(S.getMyLength());
      StartList.add(BuffM);
    }
    ProgList=StartList;
  }
  public void setProgList(LinkedList<MBitSet> newPLst)
  {
    ProgList=newPLst;
  }
  public LinkedList<MBitSet> getProgList()
  {
    return ProgList;
  }
  public void printProgs()
  {
    for(MBitSet S : ProgList)
    {
      System.out.println(S.toString());
    }
  }
  public void printProgsSize()
  {
    System.out.println(progLen);
  }
}

