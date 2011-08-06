(* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : mama_mia.sml

* Purpose :

* Creation Date : 06-08-2011

* Last Modified : Sat 20 Dec 2008 09:37:30 AM PST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*)





fun encode (c:char) [] = [(c,1)]
|   encode (c:char) ((hc:char,hn:int)::tl) = 
  if (c=hc) then (c,(hn+1))::tl
  else (c,1)::(hc,hn)::tl


fun decode rle =
  let
    fun decodeH [] (s:char list) = s
    |   decodeH ((hc:char,1)::tl) (s:char list) = decodeH tl (hc::s)
    |   decodeH ((hc:char,hn)::tl) (s:char list) = decodeH ((hc,hn-1)::tl) (hc::s)
  in
    decodeH rle []
  end


fun main() =
  let
    val t = (CommandLine.arguments())
    val st = if not ((length (t)) = 6)
      then 
        "Usage mama_mia a m li hi lo ho\n"
      else
        let
          val a::m::li::hi::lo::ho = t

        in
          "DD\n"
        end
  in 
    print (st)
  end
  
(*val _ = main()*)
