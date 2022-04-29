package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;

public class DefaultNecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery i, JewelleryStorage s) {
        return s.tree.add(i);
    }
}
