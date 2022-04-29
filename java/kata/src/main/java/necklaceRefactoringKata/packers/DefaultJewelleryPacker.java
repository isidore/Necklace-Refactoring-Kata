package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;

public class DefaultJewelleryPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        return storage.dresserTop.add(item);
    }
}
