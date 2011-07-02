% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : magic.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Sat 02 Jul 2011 09:10:41 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/



  quick_sort(List,Sorted):-q_sort(List,[],Sorted).
  q_sort([],Acc,Acc).
  q_sort([H|T],Acc,Sorted):-
    pivoting(H,T,L1,L2),
      q_sort(L1,Acc,Sorted1),q_sort(L2,[H|Sorted1],Sorted).



  pivoting(_,[],[],[]).
  pivoting(H,[X|T],[X|L],G):-X=<H,pivoting(H,T,L,G).
  pivoting(H,[X|T],L,[X|G]):-X>H,pivoting(H,T,L,G).


  sub(BASE,A,B,C) :-
   subH(BASE,A,B,0,[],C).

  subH(_   ,[]     ,_     ,_    ,ACC,ACC) .
  subH(BASE,[A|AS] ,[B|BS],CARRY,ACC,X) :-
    AL is B-A-CARRY,
    (AL<0 -> DIG is AL+BASE , CARRY2 = 1; DIG=AL,CARRY2 = 0),
    subH(BASE,AS,BS,CARRY2,[DIG|ACC],X) .

  is_Magic(A,BASE) :-
    sort(A,SA),
    reverse(SA,RSA),
    sub(BASE,RSA,SA,A).
    
  magic(DIGITS,BASE,NUM) :-
    length(NUM,DIGITS),
    is_Magic(NUM,BASE).
