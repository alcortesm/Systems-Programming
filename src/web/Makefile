OUT_DIR := ../../out
SRC_FILES := index.html style.css
OUT_FILES := $(addprefix $(OUT_DIR)/, $(SRC_FILES))

.PHONY : all clean

all : $(OUT_FILES)

clean : ;

$(OUT_FILES) : $(OUT_DIR)/% : % | $(OUT_DIR)
	cp $< $@

$(OUT_DIR) :
	mkdir $(OUT_DIR)

