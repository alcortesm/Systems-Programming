subdirs := $(shell find $(CURDIR) -mindepth 1 -maxdepth 1 -type d)

.PHONY: all, clean, $(subdirs)

all: TARGET=all
all: $(subdirs)

clean: TARGET=clean
clean: $(subdirs)

$(subdirs):
	$(MAKE) -C $@ $(TARGET)
