/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : MBitSet.java

* Purpose :

* Creation Date : 03-08-2011

* Last Modified : Wed 03 Aug 2011 01:02:57 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.BitSet;

public class MBitSet extends BitSet
{
  private int myLength;
  private StringBuilder SBLD;
  
  MBitSet()
  {
    super();
    myLength=0;
    SBLD = new StringBuilder();
  }
  public void set(int index)
  {
    super.set(index);
    myLength++;
  }
  public void clear(int index)
  {
    super.clear(index);
    myLength++;
  }
  public int getMyLength()
  {
    return myLength;
  }
  public String toString()
  {
    SBLD = new StringBuilder(myLength);
    for (int i =0; i < myLength ; i++)
    {
      if(this.get(i))
      {
        SBLD.append("A");
      }
      else
      {
        SBLD.append("M");
      }
    }
    return SBLD.toString();
  }

}
