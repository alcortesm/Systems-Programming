name := PrimesUntilGraph
data := data.dat

eps := $(name).eps

.PHONY: all clean destroy_data

all : $(eps)

$(eps) : draw.gnuplot $(data)
	gnuplot draw.gnuplot

clean :
	- rm $(eps)

$(data) :
	bash generate_data.bash

destroy_data :
	- rm $(data)
