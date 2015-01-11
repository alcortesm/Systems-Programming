name := world-max-1

# build
src := $(name).dia
out := $(src:%.dia=%.pdf)

.PHONY : all clean

all : $(out)

$(out) : $(src)
	dia $< --export=$@ --filter=pdf
	pdfcrop $@ $@

clean :
	- rm $(out)
