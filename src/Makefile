subdirs := $(shell find $(CURDIR) -mindepth 1 -maxdepth 1 -type d | grep -v './sty')

.PHONY: all clean $(subdirs)

all: TARGET=all
all: $(subdirs)

clean: TARGET=clean
clean: $(subdirs)

$(subdirs):
	$(MAKE) -C $@ $(TARGET)
