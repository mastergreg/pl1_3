/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 06 Jul 2011 12:21:55 AM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

public class Runner
{
  int a=0;
  int m=0;
  int li=0;
  int hi=0;
  int mlo=0;
  int mho=0;
  String prog;
  Runner(int a,int m,int li,int hi,String prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  void run()
  {
    for(int i = 0; i < prog.length() ; i++)
    {
      char c = prog.charAt(i);
      if (c=='A')
      {
        mlo+=a;
        mho+=a;
      }
      else
      {
        mlo*=m;
        mho*=m;
      }
    }
  }
  public int getMHO()
  {
    return mho;
  }
  public int getMLO()
  {
    return mlo;
  }
  public boolean outPutCheck(int lo,int ho)
  {
    if(mlo<lo) return false;
    if(mho>ho) return false;
    if(mlo>ho) return false;
    if(mho<lo) return false;
    return true;
  }
}
