package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;

class DefaultNecklacePacker implements PackerApplesauce {
    @Override
    public boolean pack(Jewellery i, JewelleryStorage s) {
        return s.tree.add(i);
    }
}
