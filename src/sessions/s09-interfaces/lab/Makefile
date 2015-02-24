OUT_DIR := ../../../../out/pub/sessions/s09-lab
SRC_FILES := with-solutions.html style.css index.html Point.java
OUT_FILES := $(addprefix $(OUT_DIR)/, $(SRC_FILES))

.PHONY : all clean

all : $(OUT_FILES)

clean : ;

$(OUT_FILES) : $(OUT_DIR)/% : % | $(OUT_DIR)
	cp $< $@

$(OUT_DIR) :
	mkdir -p $(OUT_DIR)

