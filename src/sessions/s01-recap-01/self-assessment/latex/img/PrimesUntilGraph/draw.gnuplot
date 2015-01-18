set terminal eps size 14cm,8cm font 'Arial,11'
set output 'PrimesUntilGraph.eps'
set key left top
set ylabel "Time (s)"
set xlabel "Numbers checked"
set xrange [0:]
plot "data.dat" using 1:2 with linespoints pt 4 title "PrimesUntilSlow" \
    ,\
    "data.dat" using 1:3 with linespoints pt 6 title "PrimesUntilTrialDivision" \
    ,\
    "data.dat" using 1:4 with linespoints pt 8 title "SieveOfEratosthenes"

