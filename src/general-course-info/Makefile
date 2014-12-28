name := general-course-info

# build
src := $(name).tex
out := $(name).pdf

# install
pub_dir := ../../out/pub
pub_files := $(pub_dir)/$(out)

.PHONY: all install build clean

all : install

install : $(pub_files)

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(out) : $(src)
	pdflatex $<

$(pub_dir) :
	mkdir -p $(pub_dir)

clean :
	- rm $(out)
	- rm $(name).aux $(name).log $(name).out texput.log

