name := efficiency

# inputs
src := $(name).data
gp := $(name)1.gp $(name)2.gp $(name)3.gp $(name)4.gp

# outputs
eps := $(gp:%.gp=%.eps)
pdf := $(eps:%.eps=%.pdf)
out := $(name).pdf

.PHONY : all clean

all : $(out)

$(out) : $(pdf)
	pdftk $(?) cat output $(@)

$(pdf) : $(eps)
	epstopdf $(@:%.pdf=%.eps)

$(eps) : $(src) $(gp)
	gnuplot $(@:%.eps=%.gp)

clean :
	- rm $(out)
	- rm $(pdf)
	- rm $(eps)
