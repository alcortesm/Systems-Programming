set terminal eps size 14cm,8cm font 'Arial,11'
set output 'IsPrimeTrialDivisionGraph.eps'
set key left top
set ylabel "Time (s)"
set xlabel "Prime number to check"
set xrange [0:]
plot "data.dat" using 1:2 with linespoints pt 4 title "IsPrimeSlow" \
    ,\
    "data.dat" using 1:3 with linespoints pt 6 title "IsPrimeTrialDivision"

