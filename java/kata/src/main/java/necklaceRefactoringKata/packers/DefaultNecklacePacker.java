package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;

public class DefaultNecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery i, JewelleryStorage s) {
        if (!(i instanceof Necklace)) {
            return false;
        }
        return s.tree.add(i);
    }
}
