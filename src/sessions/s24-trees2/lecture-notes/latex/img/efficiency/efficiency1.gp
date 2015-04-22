#!/usr/bin/gnuplot

set terminal postscript eps color size 10cm, 10cm
set output "efficiency1.eps"

set title "Ordered Dictionaries Benchmark" font ",20"
set xlabel "Size of the dictionary"
set ylabel "Time (micro seconds)"
set xrange [5000:65000]
set yrange [-50:1000]
set key left box
set arrow from 5000,0 to 65000,0 nohead lc rgb 'gray'
set style line 1 lc 1 lt 1 lw 10 pt 1 pi -1 ps 1.5
set style line 2 lc 2 lt 2 lw 10 pt 2 pi -1 ps 1.5
set style line 3 lc 3 lt 3 lw 10 pt 3 pi -1 ps 1.5
set style line 4 lc 4 lt 4 lw 10 pt 4 pi -1 ps 1.5
set style line 5 lc 5 lt 5 lw 10 pt 5 pi -1 ps 1.5

plot "efficiency.data" using 1:2 with linespoints ls 1 title 'Unsorted Array List', \
     "efficiency.data" using 1:3 with linespoints ls 2 title 'Unsorted Linked List'

