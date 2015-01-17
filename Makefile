out := out
src := src
MAKEFLAGS += --no-print-directory
spell_check_zip := $(out)/spell-check.zip
spell_check_dir := $(out)/html-versions-of-pdfs

.PHONY: all clean nuke spell-check

all:
	$(MAKE) -C $(src) all

clean:
	$(MAKE) -C $(src) clean

nuke: clean
	- rm -r $(out)

spell-check : $(spell_check_zip)

$(spell_check_zip) :
	(cd $(spell_check_dir) ; zip -r ../../$(spell_check_zip) *)
