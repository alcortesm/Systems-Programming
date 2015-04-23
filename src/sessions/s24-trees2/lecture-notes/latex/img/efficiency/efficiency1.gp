#!/usr/bin/gnuplot

load "common.gp"

set output "efficiency1.eps"

plot "efficiency.data" using 1:4 with linespoints ls 1 title 'Array List'
