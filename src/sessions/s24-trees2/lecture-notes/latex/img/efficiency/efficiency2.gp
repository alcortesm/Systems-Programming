#!/usr/bin/gnuplot

set terminal postscript eps color size 10cm, 10cm
set output "efficiency2.eps"

set title "Ordered Dictionaries Benchmark" font ",20"
set xlabel "Size of the dictionary"
set ylabel "Time (micro seconds)"
set xrange [0:4100]
set yrange [-50:2400]
set key left box
set arrow from 0,0 to 4100,0 nohead lc rgb 'gray'
set style line 1 lc 1 lt 1 lw 5 pt 1 pi -1 ps 1
set style line 2 lc 2 lt 2 lw 5 pt 2 pi -1 ps 1
set style line 3 lc 3 lt 3 lw 5 pt 3 pi -1 ps 1
set style line 4 lc 4 lt 4 lw 5 pt 4 pi -1 ps 1
set style line 5 lc 5 lt 5 lw 5 pt 5 pi -1 ps 1

plot "efficiency.data" using 1:4 with linespoints ls 1 title 'Unsorted Array List', \
     "efficiency.data" using 1:5 with linespoints ls 2 title 'Unsorted Linked List'

