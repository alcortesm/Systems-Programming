name := schedule

# build
src := $(name).dia
out := $(name).pdf

# install
pub_dir := ../../out/pub
pub_files := $(pub_dir)/$(out)

.PHONY : all install install clean

all : install

install : build $(pub_files)

build : $(out)

clean :
	- rm $(out)

$(out) : $(src)
	dia --export=$(out) --filter=pdf $(src)

$(pub_files) : $(out) | $(pub_dir)
	cp $< $@

$(pub_dir) :
	mkdir -p $(pub_dir)

