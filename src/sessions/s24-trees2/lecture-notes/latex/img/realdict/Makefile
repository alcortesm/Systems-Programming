name := realdict

# build
src := $(name)1.dia $(name)2.dia $(name)3.dia $(name)4.dia $(name)5.dia
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
