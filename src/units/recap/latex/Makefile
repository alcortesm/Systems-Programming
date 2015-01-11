name := recap
imgs := img/world-max-?/world-max-?.pdf img/world-data/world-data.pdf

# build
src := $(name).tex
out := $(name).pdf

# install
pub_dir := ../../../../out/pub/units/recap
pub_files := $(pub_dir)/$(out)

.PHONY: all install build clean imgs

all : imgs install

install : $(pub_files)

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(out) : $(src) $(imgs)
	pdflatex $(src)

$(pub_dir) :
	mkdir -p $(pub_dir)

imgs :
	$(MAKE) -C img all

clean :
	- rm $(out)
	- rm $(name).aux $(name).log $(name).out texput.log
	$(MAKE) -C img clean

