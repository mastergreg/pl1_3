/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : Runner.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 10 Aug 2011 02:53:11 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/
import java.math.BigInteger;

public class Runner
{
  private int a=0;
  private int m=0;
  private int li=0;
  private int hi=0;
  private int mlo=0;
  private int mho=0;
  private BigInteger prog;

  Runner()
  {

  }
  Runner(int a,int m,int li,int hi,BigInteger prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void SetRunner(int a,int m,int li,int hi,BigInteger prog)
  {
    this.a=a;
    this.m=m;
    this.li=li;
    this.mlo=li;
    this.hi=hi;
    this.mho=hi;
    this.prog = prog;
  }
  public void run()
  {

      int len = prog.bitLength()-1;

      //System.out.println(len);
      for(int i = 0; i < len ; i++)
      {
        if (prog.testBit(i))
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
  public int outPutCheck(int lo,int ho)
  {
    if(mho-mlo>ho-lo) return 1;
    if(mho>ho) return 1; //high out exceeded
    if(mlo>ho) return 1; //
    if(mlo<lo) return 2; //low out not reached
    if(mho<lo) return 2; //
    return 0;
  }
  public String toString()
  {
    StringBuilder ST = new StringBuilder();
    int len = prog.bitLength()-1;
    for(int i = 0; i < len ; i++)
    {
      if (prog.testBit(i))
      {
        ST.append("A");
      }
      else
      {
        ST.append("M");
      }
    }
    return ST.toString();
  }
}
