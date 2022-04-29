package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;

public class TravelRollPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {

        if (!storage.IsInTravelRoll(item) || item.isLarge()) {
            return false;
        }
        return storage.box.topShelf.add(item);
    }
}
