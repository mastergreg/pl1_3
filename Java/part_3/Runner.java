/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Thu 04 Aug 2011 01:34:23 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

public class Runner
{
  private int a=0;
  private int m=0;
  private int li=0;
  private int hi=0;
  private int mlo=0;
  private int mho=0;
  private Program prog;
  private int width=0;
  private int mwidth=0;

  Runner()
  {

  }
  Runner(int a,int m,int li,int hi,Program prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void SetRunner(int a,int m,int li,int hi,Program prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  private void run()
  {
    int len = prog.getMyLength();
    for(int i = 0; i < len ; i++)
    {
      if (prog.get(i))
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
    mwidth=mho-mlo;
  }
  public int getMHO()
  {
    return mho;
  }
  public int getMLO()
  {
    return mlo;
  }
  public int outPutCheck(int lo,int ho)
  {
    run();
    width=ho-lo;
    if(mwidth>width) return 1;
    if(mho>ho) return 1; //high out exceeded
    if(mlo>ho) return 1; //
    if(mlo<lo) return 2; //low out not reached
    if(mho<lo) return 2; //
    return 0;
  }
}
