package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.packers.*;

public class Packer {

    public static void packNecklace(Necklace item, JewelleryStorage storage) {
        packItem(item, storage, new NecklacePacker());
    }

    private static void packItem(Jewellery item, JewelleryStorage storage, PackLogic...packers) {
        for (PackLogic packer : packers) {
            if (packer.pack(item, storage)) {
                return;
            }
        }
    }

    public static boolean pack(Jewellery item, JewelleryStorage storage) {
        if (storage.IsInTravelRoll(item) && !item.isLarge()) {
            storage.box.topShelf.add(item);
            storage.travelRoll.remove(item);
            return true;
        } else if (item.stone == Jewel.Diamond) {
            storage.safe.add(item);
            return removeItem(item, storage);
        }

        packItem(item, storage,
                new SmallPacker(),
                new EarringHoopPacker(),
                new EarringDropPacker(),
                new PendantNecklacePacker(),
                new DefaultNecklacePacker(),
                new DefaultJewelleryPacker()
        );
        removeItem(item, storage);
        return true;
    }

    private static boolean removeItem(Jewellery item, JewelleryStorage storage) {
        if (storage.IsInTravelRoll(item)) {
            storage.travelRoll.remove(item);
        }
        return true;
    }

}
