name := general-course-info

# build
src := $(name).tex
out := $(name).pdf
dvi := $(name).dvi
ps := $(name).ps
html_out := html-version

# install
out_dir := ../../out
pub_dir := $(out_dir)/pub
pub_files := $(pub_dir)/$(out)
html_dir := $(out_dir)/html-versions-of-pdfs

.PHONY: all install build clean html

all : install

install : $(pub_files) html

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(out) : $(src)
	latex $<
	latex $<
	dvips $(dvi)
	ps2pdf $(ps)

$(pub_dir) :
	mkdir -p $(pub_dir)

clean :
	- rm $(out) $(dvi) $(ps)
	- rm $(name).aux $(name).log $(name).out texput.log
	- rm $(name).4ct $(name).4tc
	- rm $(name).idv $(name).lg $(name).tmp $(name).xref
	- rm -rf $(html_out)

html : $(html_out)

$(html_out) : $(src) | $(html_dir)
	mkdir -p $(html_out)/$(name)
	htlatex $(src) '"xhtml,url-enc"' '""' '"-dhtml-version/$(name)/"'
	- rm $(name).html
	- rm $(name).css
	cp -r $(html_out)/$(name) $(html_dir)

$(html_dir) :
	mkdir -p $(html_dir)

