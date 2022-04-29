package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;

public class SmallPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!item.isSmall()) {
            return false;
        }
        return storage.box.topShelf.add(item);
    }
}
