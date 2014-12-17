out := out
src := src
MAKEFLAGS += --no-print-directory

.PHONY: all clean nuke

all:
	$(MAKE) -C $(src) all

clean:
	$(MAKE) -C $(src) clean

nuke: clean
	rm -r $(out)
