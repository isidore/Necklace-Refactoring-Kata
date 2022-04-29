package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;

public class SmallNecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!item.isLarge()) {
            storage.box.topShelf.add(item);
            return true;
        }
        return false;
    }
}
