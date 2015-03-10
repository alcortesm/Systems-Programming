number := s14
name := $(number)-self-assessment
name2 := $(name)-with-solutions
sty := ../../../../sty
export TEXINPUTS := $(sty):${TEXINPUTS}

# build
src := $(name).tex
out := $(name).pdf
dvi := $(name).dvi
ps := $(name).ps
src2 := $(name2).tex
out2 := $(name2).pdf
dvi2 := $(name2).dvi
ps2 := $(name2).ps
html_out := html-version

# install
out_dir := ../../../../../out
pub_dir := $(out_dir)/pub/sessions
pub_files := $(pub_dir)/$(out)
pub_dir2 := $(out_dir)/teacher
pub_files2 := $(pub_dir2)/$(out2)
html_dir := $(out_dir)/html-versions-of-pdfs

.PHONY: all install build clean imgs html

all : imgs install

install : $(pub_files) $(pub_files2)

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(pub_files2) : $(out2) | $(pub_dir) html
	cp $(out2) $(pub_files2)

$(out) : $(src)
	latex $(src)
	latex $(src)
	dvips $(dvi)
	ps2pdf $(ps)

$(out2): $(src2) $(src)
	latex $(src2)
	latex $(src2)
	dvips $(dvi2)
	ps2pdf $(ps2)

$(pub_dir) :
	mkdir -p $(pub_dir)
	mkdir -p $(pub_dir2)

imgs :
	$(MAKE) -C img all

clean :
	- rm $(out) $(dvi) $(ps) $(out2) $(dvi2) $(ps2)
	- rm $(name).aux $(name).log $(name).out texput.log
	- rm $(name2).aux $(name2).log $(name2).out texput.log
	- rm $(name2).4ct $(name2).4tc
	- rm $(name2).idv $(name2).lg $(name2).tmp $(name2).xref
	$(MAKE) -C img clean
	- rm -rf html-version

html : $(html_out)/$(name2)/$(name2).html

$(html_out)/$(name2)/$(name2).html : $(src) | $(html_dir)
	mkdir -p $(html_out)/$(name2)
	htlatex $(src2) '"html,url-enc"' '""' '"-dhtml-version/$(name2)/"'
	- rm $(name2).html
	- rm $(name2).css
	cp -r $(html_out)/$(name2) $(html_dir)

$(html_dir) :
	mkdir -p $(html_dir)
