OUT_DIR := ../../../../out/pub/sessions/s07-lab
SRC_FILES := with-solutions.html style.css a.svg b.svg c.svg d.svg e.svg
OUT_FILES := $(addprefix $(OUT_DIR)/, $(SRC_FILES))

.PHONY : all clean

all : $(OUT_FILES)

clean : ;

$(OUT_FILES) : $(OUT_DIR)/% : % | $(OUT_DIR)
	cp $< $@

$(OUT_DIR) :
	mkdir -p $(OUT_DIR)

