#!/bin/bash

out="data.out"
seed="523"
flags="-Xint -Djava.compiler=NONE"
# flags="-Xint"
# flags="-Djava.compiler=NONE"
# flags=""
begin="1000"
end="10000"
step="500"

rm $out

echo -e "# size\ttimes\tseed\tAL\tLL\tSAL\tSLL\tBST" > $out
tail -1 $out

for ((i=$begin; i<=$end; i=i+$step)); do
    java $flags ODTime $i $i $seed >> $out
    tail -1 $out
done
