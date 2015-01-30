name := while

eps := $(name).eps

.PHONY: all clean

all : $(eps)

$(eps) : $(name).dia
	dia $< --export=$@ --filter=eps

clean :
	- rm $(eps)
