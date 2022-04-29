package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;

public class DiamondNecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (item.stone == Jewel.Diamond) {
            storage.safe.add(item);
            return true;
        }
        return false;
    }
}
