package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;

public class EarringDropPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!(item instanceof Earring earring) || earring.type != EarringType.Drop) {
            return false;
        }
        if (earring.stone == Jewel.Plain) {
            storage.box.mainSection.add(earring);
        } else {
            storage.box.topShelf.add(earring);
        }
        return true;
    }
}
