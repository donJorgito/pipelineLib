def call(String ELEMENT) {

        def HACK = ''

        if ("${ELEMENT.getClass()}" =~ $/.*?GStringImpl/$) {
            def STRGSTRING = ELEMENT.getStrings()
            def NEWVALUES = []

            for (int j = 0; j < ELEMENT.getValues().size(); j++) {
                if (ELEMENT.getValues()[j] instanceof java.lang.String) {
                    NEWVALUES.add(ELEMENT.getValues()[j])
                } else {
                    if (ELEMENT.getValues()[j] != null) {
                        NEWVALUES.add(ELEMENT.getValues()[j].call())
                    }
                }
            }

            //NOTE: This expects the original GString starting with a non closure element
            for (int k = 0; k < STRGSTRING.size(); k++) {
                if (NEWVALUES[k] == null) {
                    HACK += STRGSTRING[k]
                } else {
                    HACK += STRGSTRING[k] + NEWVALUES[k]
                }
            }
        }

        return (HACK == '') ? ELEMENT : HACK
    }
