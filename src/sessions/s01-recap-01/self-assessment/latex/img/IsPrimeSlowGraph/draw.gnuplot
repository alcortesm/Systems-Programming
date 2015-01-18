set terminal eps size 14cm,8cm font 'Arial,11'
set output 'IsPrimeSlowGraph.eps'
set key left top
set ylabel "Time (s)"
set xlabel "Prime number to check"
set xrange [0:]
plot "data.dat" with linespoints pt 4 title "IsPrimeSlow"

