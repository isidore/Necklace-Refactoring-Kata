package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewellery;

public class EarringHoopPacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (!(item instanceof Earring earring) || earring.type != EarringType.Hoop) {
            return false;
        }
        storage.tree.add(earring);
        return true;
    }
}
