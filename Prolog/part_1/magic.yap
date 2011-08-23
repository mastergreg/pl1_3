% /* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.
% 
% * File Name : magic.yap
% 
% * Purpose :
% 
% * Creation Date : 28-06-2011
% 
% * Last Modified : Tue 23 Aug 2011 01:26:12 PM EEST
% 
% * Created By : Greg Liras <gregliras@gmail.com>
% 
% _._._._._._._._._._._._._._._._._._._._._.*/

  :-initialization(use_module(library(lists))).
  quick_sort(List,Sorted):-
    q_sort(List,[],Sorted).
  q_sort([],Acc,Acc).
  q_sort([H|T],Acc,Sorted):-
    pivoting(H,T,L1,L2),
    q_sort(L1,Acc,Sorted1),q_sort(L2,[H|Sorted1],Sorted).
  pivoting(_,[],[],[]).
  pivoting(H,[X|T],[X|L],G):-X=<H,pivoting(H,T,L,G).
  pivoting(H,[X|T],L,[X|G]):-X>H,pivoting(H,T,L,G).

  sub(BASE,A,B,C) :-
   subH(BASE,A,B,0,C).
  subH(_   ,[]     ,_     ,_    ,[]) :-!.
  subH(BASE,[A|AS] ,[B|BS],CARRY,[C|CS]) :-
    AL is B-A-CARRY,
    (AL<0 -> C is AL+BASE , CARRY2 = 1; C=AL,CARRY2 = 0),
    subH(BASE,AS,BS,CARRY2,CS) .

  is_Magic(A,BASE) :-
    quick_sort(A,SA),
    reverse(SA,RSA),
    sub(BASE,SA,RSA,A).
    
  %returns the next number (not sorted)
  next(BASE,A,NXT) :-
    nextH2(BASE,A,NXT,1).
  nextH2(_   ,[]    ,[]     ,_) :- !.
  nextH2(_   ,AS    ,AS     ,0) :- !.
  nextH2(BASE,[A|AS],[N|NXT],CARRY):-
    DIG is A+CARRY,
    (
      DIG<BASE -> (DIG = N, CARRY2 = 0 )
      ; (N is 0 , CARRY2 = 1)
    ),
    nextH2(BASE,AS,NXT,CARRY2).

  %builds nextReverse with tail recursion
  nextREV(BASE,A,NXT) :-
    nextHREV(BASE,A,NXT,1,[]).
  nextHREV(_,[],ACC,_,ACC):-!.
  nextHREV(BASE,[A|AS],NXT,CARRY,ACC):-
    DIG is A+CARRY,
    (
      DIG<BASE -> AL = DIG, CARRY2 = 0 
      ; (AL is 0 , CARRY2 = 1)
    ),
    nextHREV(BASE,AS,NXT,CARRY2,[AL|ACC]).

  %checks to be sorted
  makeSNEXT(_  ,[]  ,[]   ):-!.
  makeSNEXT(MAX,[R|RNXT],[S|SRNXT]):-
    (
        MAX<R -> MAX2 = R,S = R
      ;
        MAX2 = MAX , S=MAX
    ),
    makeSNEXT(MAX2,RNXT,SRNXT).

  %builds sorted next nubers at the desired base

  superNEXT(BASE,A,SNXT):-
    nextREV(BASE,A,RNXT),
    makeSNEXT(0,RNXT,SRNXT),
    reverse(SRNXT,SNXT).

    

  %build a zero filled initial list
  makeStart([]    ,0):-!.
  makeStart([L|LS],DIGITS):-!,
    NDIG is DIGITS-1,
    L=0,
    makeStart(LS,NDIG).

  %produce the contestant based on NUM
  makeContestant(BASE,NUM,CONTESTANT):-
      reverse(NUM,RSNUM),
      sub(BASE,NUM,RSNUM,CONTESTANT).

  %check if the list has exceeded the limit
  failNum(LIMIT,NUM):-
    nth(LIMIT,NUM,A),
    A>0.  

  %finds Magic if exists, returns 0 otherwise
  findMagic(LIMIT,BASE,NUM,RNUM):-
    (
        failNum(LIMIT,NUM) -> RNUM=0 
      ;
        makeContestant(BASE,NUM,CONTESTANT),
      (
        is_Magic(CONTESTANT,BASE) -> RNUM=CONTESTANT
      ; 
        superNEXT(BASE,NUM,NEXT),
        findMagic(LIMIT,BASE,NEXT,RNUM)
      )
    ).

  %computes magic from base to dec
  computed(_,[],_,RESULT,RESULT):-!.
  computed(BASE,[N|NUM],POWER,RESULT,RETURN):-
    RESULT2 is RESULT+N*BASE^POWER,
    POWER2 is POWER+1,
    computed(BASE,NUM,POWER2,RESULT2,RETURN).

  
  magic(BASE,DIGITS,NUM) :-
    makeStart(ST,DIGITS),
    next(BASE,ST,START),
    LIMIT is truncate(DIGITS/2)+1,
    findMagic(LIMIT,BASE,START,RNUM),
    computed(BASE,RNUM,0,0,NUM2),
    (
      NUM2 = 0.0 -> fail
      ;
      NUM = NUM2
    ).
