name := s08-lecture-notes
imgs := $(wildcard img/*/*.pdf)
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
pub_dir := $(out_dir)/teacher
pub_files := $(pub_dir)/$(out)
html_dir := $(out_dir)/html-versions-of-pdfs
demo_dir := $(pub_dir)/s08-demo

.PHONY: all install build clean imgs html

all : imgs install demo

install : $(pub_files) html

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(out) : $(src) $(imgs)
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
	- rm $(name).4ct $(name).4tc
	- rm $(name).idv $(name).lg $(name).tmp $(name).xref
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

demo :
	rm -rf $(demo_dir)
	mkdir -p $(demo_dir)
	cp ./img/uml_square/uml_square.eps $(demo_dir)
	cp ./img/uml_shape_1/uml_shape_1.eps $(demo_dir)
	mkdir $(demo_dir)/v1
	cp ../java/v1/*.java $(demo_dir)/v1
	cp ./img/uml_shape_2/uml_shape_2.eps $(demo_dir)
	cp ./img/uml_graphicalshape/uml_graphicalshape.eps $(demo_dir)
	mkdir $(demo_dir)/v2
	cp ../java/v2/*.java $(demo_dir)/v2
	cp ./img/abstract_rules/abstract_rules.eps $(demo_dir)
	cp ./img/number/number.eps $(demo_dir)
	cp ./img/abstractlist/abstractlist.eps $(demo_dir)
	cp ./img/interfaces_rules/interfaces_rules.eps $(demo_dir)
	cp ./img/drawable/drawable.eps $(demo_dir)
	cp ./img/extends_implements/extends_implements.eps $(demo_dir)
	cp ./img/important_interfaces/important_interfaces.eps $(demo_dir)
	cp ./img/abstractlist_interface/abstractlist_interface.eps $(demo_dir)

