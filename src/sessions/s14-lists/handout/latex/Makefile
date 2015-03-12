number := s14
name := $(number)-handout
sty := ../../../../sty
export TEXINPUTS := $(sty):${TEXINPUTS}

# build
src := $(name).tex
out := $(name).pdf
dvi := $(name).dvi
ps := $(name).ps
html_out := html-version

# install
out_dir := ../../../../../out
pub_dir := $(out_dir)/pub/sessions
pub_files := $(pub_dir)/$(out)
html_dir := $(out_dir)/html-versions-of-pdfs

.PHONY: all install build clean imgs html

all : imgs install html

install : $(pub_files)

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(out) : $(src)
	latex $(src)
	latex $(src)
	dvips $(dvi)
	ps2pdf $(ps)

$(pub_dir) :
	mkdir -p $(pub_dir)

imgs :
	$(MAKE) -C img all

clean :
	- rm $(out) $(dvi) $(ps)
	- rm $(name).aux $(name).log $(name).out texput.log
	$(MAKE) -C img clean
	- rm -rf html-version

html : $(html_out)/$(name)/$(name).html

$(html_out)/$(name)/$(name).html : $(src) | $(html_dir)
	mkdir -p $(html_out)/$(name)
	htlatex $(src) '"html,url-enc"' '""' '"-dhtml-version/$(name)/"'
	- rm $(name).html
	- rm $(name).css
	cp -r $(html_out)/$(name) $(html_dir)

$(html_dir) :
	mkdir -p $(html_dir)
