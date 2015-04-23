#!/usr/bin/gnuplot

load "common.gp"

set output "efficiency4.eps"

plot "efficiency.data" using 1:4 with linespoints ls 1 title 'Array List', \
     "efficiency.data" using 1:5 with linespoints ls 2 title 'Linked List', \
     "efficiency.data" using 1:7 with linespoints ls 3 title 'Sorted Linked List', \
     "efficiency.data" using 1:6 with linespoints ls 4 title 'Sorted Array List'

