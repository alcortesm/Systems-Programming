name_pub := s01-required-reading-1
sty := ../../../../sty

# build
src_pub := $(name_pub).tex
out_pub := $(name_pub).pdf

# install
dir_out := ../../../../../out
dir_pub := $(dir_out)/pub/sessions
file_pub := $(dir_pub)/$(out_pub)

.PHONY : all install build clean imgs

all : imgs install ;

install : $(file_pub) ;

$(file_pub) : $(out_pub) | $(dir_pub)
	cp $< $@

$(out_pub) : $(src_pub) $(imgs)
	TEXINPUTS=$(sty):$(TEXINPUTS) pdflatex $(src_pub)
	TEXINPUTS=$(sty):$(TEXINPUTS) pdflatex $(src_pub)

$(dir_pub) :
	mkdir -p $(dir_pub)

clean :
	- rm $(out_pub)
	- rm $(name_pub).aux
	- rm $(name_pub).log
	- rm $(name_pub).out
	- rm $(name_pub).toc
	- rm texput.log
