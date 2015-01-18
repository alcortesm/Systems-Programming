#!/bin/bash

primes[1]=10000019
primes[2]=100000007
primes[3]=200000033
primes[4]=300000007
primes[5]=400000009
primes[6]=500000003
primes[7]=600000001
primes[8]=700000001

out_file=data.dat
rm -f $out_file

for prime in ${primes[@]} ; do
    echo -n "${prime} " >> $out_file
    echo `(time -p java -classpath ../../../java IsPrimeSlow $prime) 2>&1 >/dev/null | grep 'user' | cut -d' ' -f2` >> $out_file
done

