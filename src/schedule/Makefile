# build
SRC := schedule.dia
OUT := $(SRC:.dia=.pdf)

# install
PUB_DIR := ../../out/pub
PUB_FILES := $(addprefix $(PUB_DIR)/, $(OUT))

.PHONY : all build install clean

all : $(PUB_FILES)

clean :
	- rm $(OUT)

$(OUT) : $(SRC)
	dia --export=$(OUT) --filter=pdf $(SRC)

$(PUB_FILES) : $(PUB_DIR)/% : % | $(PUB_DIR)
	cp $< $@

$(OUT_DIR) :
	mkdir -p $(OUT_DIR)

