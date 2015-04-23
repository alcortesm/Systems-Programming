#!/bin/bash

out="data.out"
seed="345"
flags="-Xint -Djava.compiler=NONE"
begin="100"
end="200"
step="100"

rm $out

echo -e "# size\ttimes\tseed\tUAL\tULL\tSAL\tSLL\tBST" > $out
tail -1 $out

for ((i=$begin; i<=$end; i=i+$step)); do
    java $flags ODTime $i $i $seed >> $out
    tail -1 $out
done
