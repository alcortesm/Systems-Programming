number := s22
name := $(number)-lecture-notes
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
demo_dir := $(pub_dir)/$(number)-demo
zip := $(out_dir)/pub/sessions/$(number)-src.zip

.PHONY: all install build clean imgs html zip

all : imgs install demo

install : $(pub_files) html zip

zip:
	- rm $(zip)
#	zip -j -r $(zip) ../java/Count1ToN*.java ../java/CountNTo1*.java ../java/EvenOrOdd.java ../java/Factorial*.java ../java/FibonacciMemoization.java ../java/FibonacciRecursive.java ../java/IsPalindrome*.java ../java/LinkedStackRecursiveContains.java ../java/Stack.java

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
	cp ./img/fibonacci/fibonacci.eps ./img/object/object.eps ./img/music/music.eps ./img/map/map.eps ./img/madrid-rome/madrid-rome.eps ./img/knapsack/knapsack.eps ./img/tree1/tree1.pdf ./img/tree2/tree2.pdf ./img/graph/graph.pdf ./img/btrees/btrees.pdf ./img/arraybtree/arraybtree.eps ./img/linkedbnode/linkedbnode.pdf ./img/traversals/traversals.eps $(demo_dir)
