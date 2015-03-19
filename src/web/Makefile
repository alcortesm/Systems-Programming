OUT_DIR := ../../out/pub
SRC_FILES := index.html style.css staff.html materials.html exam-instructions.html
OUT_FILES := $(addprefix $(OUT_DIR)/, $(SRC_FILES))

.PHONY : all clean

all : $(OUT_FILES)

clean : ;

$(OUT_FILES) : $(OUT_DIR)/% : % | $(OUT_DIR)
	cp $< $@

$(OUT_DIR) :
	mkdir -p $(OUT_DIR)

