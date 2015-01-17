name := s01-lecture-notes
imgs := $(wildcard img/*/*.pdf)

# build
src := $(name).tex
out := $(name).pdf
html_out := html-version

# install
out_dir := ../../../../../out
pub_dir := $(out_dir)/teacher
pub_files := $(pub_dir)/$(out)
html_dir := $(out_dir)/html-versions-of-pdfs

.PHONY: all install build clean imgs html

all : imgs install

install : $(pub_files) html

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
	- rm -rf html-version

html : $(html_out)

$(html_out) : $(src) | $(html_dir)
	mkdir -p $(html_out)/$(name)
	latex2html -dir $(html_out)/$(name) -html_version 4.0,unicode -no_navigation -split +0 $(src)
	cp -r $(html_out)/$(name) $(html_dir)

$(html_dir) :
	mkdir -p $(html_dir)
