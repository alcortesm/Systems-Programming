name := pq_implementations

# build
src := $(name)-00.dia $(name)-01.dia $(name)-02.dia $(name)-03.dia $(name)-03.dia $(name)-04.dia $(name)-05.dia $(name)-06.dia $(name)-07.dia $(name)-08.dia $(name)-09.dia $(name)-10.dia $(name)-11.dia $(name)-12.dia $(name)-13.dia $(name)-14.dia $(name)-15.dia $(name)-16.dia
out := $(src:%.dia=%.eps)
tmp := $(src:%.dia=%.pdf)
pdf := $(name).pdf

.PHONY : all clean

all : $(out) $(pdf)

$(out) : $(src)
	dia $(@:%.eps=%.dia) --export=$@ --filter=eps

$(tmp) : $(out)
	epstopdf $(@:%.pdf=%.eps)

$(pdf) : $(tmp)
	pdftk $(?) cat output $(@)

clean :
	- rm $(out)
	- rm $(tmp)
	- rm $(pdf)
