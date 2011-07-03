% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : magic.pl
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Sun 03 Jul 2011 03:34:26 AM EEST
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
    reverse(RA,A),
    sub(BASE,RSA,SA,RA).
    
  next(BASE,A,NXT) :-
    nextH(BASE,A,NXT,1,[]).
    
  nextH(_   ,[]    ,ACC,_    ,ACC) .
  nextH(BASE,[A|AS],NXT,CARRY,ACC) :-
    N is A+CARRY,
    (N>=BASE -> DIG is N-BASE , CARRY2 = 1 ; DIG=N , CARRY2 = 0),
    nextH(BASE,AS,NXT,CARRY2,[DIG|ACC]).

  addZeros(L,0, L).
  addZeros(L,N, FL) :-
    N2 is N - 1,
    !,
    addZeros(L,N2, [0|FL]).
  
  nth(0,[X|_],X).
  nth(N,[_|T],R):- M is N-1,nth(M,T,R).

  findMagic(DIGITS,BASE,NUM,RNUM):-
  (is_Magic(NUM,BASE) -> !,RNUM=NUM; next(BASE,NUM,NEXT) ,!,findMagic(DIGITS,BASE,NEXT,RNUM)).

  magic(DIGITS,BASE,NUM) :-
    addZeros(START,DIGITS,[]),
    !,
    reverse(RNUM,NUM),
    findMagic(DIGITS,BASE,START,RNUM).
