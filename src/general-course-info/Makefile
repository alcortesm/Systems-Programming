name := general-course-info

# build
src := $(name).tex
out := $(name).pdf
html_out := html-version

# install
out_dir := ../../out
pub_dir := $(out_dir)/pub
pub_files := $(pub_dir)/$(out)
html_dir := $(out_dir)/html-versions-of-pdfs

.PHONY: all install build clean html

all : install

install : $(pub_files)

$(pub_files) : $(out) html | $(pub_dir)
	cp $< $@

$(out) : $(src)
	pdflatex $<

$(pub_dir) :
	mkdir -p $(pub_dir)

clean :
	- rm $(out)
	- rm $(name).aux $(name).log $(name).out texput.log
	- rm -rf $(html_out)

html : $(html_out)

$(html_out) : $(src) | $(html_dir)
	mkdir -p $(html_out)/$(name)
	latex2html -dir $(html_out)/$(name) -html_version 4.0,unicode -no_navigation -split +0 $(src)
	cp -r $(html_out)/$(name) $(html_dir)

$(html_dir) :
	mkdir -p $(html_dir)

