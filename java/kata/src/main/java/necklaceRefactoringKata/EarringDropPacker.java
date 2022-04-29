package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.packers.PackLogic;

public class EarringDropPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!(item instanceof Earring earring) || earring.type != EarringType.Drop) {
            return false;
        }
        storage.box.mainSection.add(earring);
        return true;
    }
}
