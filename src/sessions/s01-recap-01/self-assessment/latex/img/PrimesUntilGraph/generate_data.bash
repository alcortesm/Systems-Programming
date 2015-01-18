#!/bin/bash

ns[1]=50000
ns[2]=100000
ns[3]=150000
ns[4]=200000
ns[5]=250000
# ns[5]=500000
# ns[6]=600000
# ns[16]=700000
# ns[17]=800000
# ns[18]=900000
# ns[19]=1000000
# ns[20]=1100000

out_file=data.dat

rm -f $out_file

for n in ${ns[@]} ; do
    echo -n "${n} " >> $out_file

    echo -n `(time -p java -classpath ../../../java PrimesUntilSlow $n) 2>&1 >/dev/null | grep 'user' | cut -d' ' -f2` >> $out_file

    echo -n " " >> $out_file

    echo -n `(time -p java -classpath ../../../java PrimesUntilTrialDivision $n) 2>&1 >/dev/null | grep 'user' | cut -d' ' -f2` >> $out_file

    echo -n " " >> $out_file

    echo `(time -p java -classpath ../../../java SieveOfEratosthenes $n) 2>&1 >/dev/null | grep 'user' | cut -d' ' -f2` >> $out_file
done

