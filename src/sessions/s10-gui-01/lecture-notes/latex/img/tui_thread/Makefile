name := tui_thread

# build
src := $(name).dia
out := $(src:%.dia=%.eps)

.PHONY : all clean

all : $(out)

$(out) : $(src)
	dia $< --export=$@ --filter=eps

clean :
	- rm $(out)
