name := is_heap

# build
src := $(name)-01.dia $(name)-02.dia $(name)-03.dia $(name)-04.dia
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
