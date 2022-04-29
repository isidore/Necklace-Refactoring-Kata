package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.PendantNecklace;

public class PendantNecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!(item instanceof PendantNecklace pendantNecklace)) {
            return false;
        }
        storage.tree.add(pendantNecklace.chain);
        storage.box.topShelf.add(pendantNecklace.pendant);
        return true;
    }
}
