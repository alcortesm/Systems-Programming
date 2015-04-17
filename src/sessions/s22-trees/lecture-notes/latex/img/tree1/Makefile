name := tree1

# build
src := $(name)a.dia $(name)b.dia $(name)c.dia $(name)d.dia $(name)e.dia
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
