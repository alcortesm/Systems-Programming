name := s01-required-reading-1
sty := ../../../../sty
export TEXINPUTS := $(sty):${TEXINPUTS}

# build
src := $(name).tex
out := $(name).pdf
dvi := $(name).dvi
ps := $(name).ps
html_out := html-version

# install
dir_out := ../../../../../out
dir_pub := $(dir_out)/pub/sessions
file_pub := $(dir_pub)/$(out)
dir_html := $(dir_out)/html-versions-of-pdfs

.PHONY : all install build clean html

all : install ;

install : $(file_pub) html ;

$(file_pub) : $(out) | $(dir_pub)
	cp $< $@

$(out) : $(src) $(imgs)
	latex $(src)
	latex $(src)
	dvips $(dvi)
	ps2pdf $(ps)

$(dir_pub) :
	mkdir -p $(dir_pub)

clean :
	- rm $(out) $(dvi) $(ps)
	- rm $(name).4ct
	- rm $(name).4tc
	- rm $(name).aux
	- rm $(name).css
	- rm $(name).html
	- rm $(name).idv
	- rm $(name).lg
	- rm $(name).log
	- rm $(name).out
	- rm $(name).tmp
	- rm $(name).xref
	- rm $(name).toc
	- rm *.png
	- rm texput.log
	- rm -rf $(html_out)

html : $(html_out) ;

$(html_out) : $(src) | $(dir_html)
	mkdir -p $(html_out)/$(name)
	htlatex $(src) '"html,url-enc"' '""' '"-d$(html_out)/$(name)/"'
	- rm $(name).html
	- rm $(name).css
	cp -r $(html_out)/$(name) $(dir_html)

$(dir_html) :
	mkdir -p $(dir_html)

