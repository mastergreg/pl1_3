#!/bin/bash
run1=$1
test1=$($1)
test1Solution=$(grep "$run1" tests)
tput sgr0                               # Reset colors to "normal."  
if [[ $test1Solution == *"$test1" ]]; then
  echo -en '\E[0;32m'$test1'\n'
else
  echo -en '\E[0;31m'$test1'\n'
fi
tput sgr0                               # Reset colors to "normal."  

