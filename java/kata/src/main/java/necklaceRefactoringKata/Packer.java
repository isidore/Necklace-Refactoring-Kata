package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Earring;
import necklaceRefactoringKata.jewellery.EarringType;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import necklaceRefactoringKata.packers.*;

public class Packer {

    public static void packNecklace(Necklace item, JewelleryStorage storage) {
        packItem(item, storage, new DiamondNecklacePacker(),
                new SmallNecklacePacker(),
                new PendantNecklacePacker(),
                new DefaultNecklacePacker());
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
        } else if (item.isSmall()) {
            storage.box.topShelf.add(item);
            return removeItem(item, storage);
        } else if (item instanceof Earring earring && earring.type == EarringType.Hoop) {
            storage.tree.add(earring);
            return removeItem(item, storage);
        } else if (item instanceof Earring earring && earring.type == EarringType.Drop && earring.stone != Jewel.Plain) {
            storage.box.topShelf.add(earring);
            return removeItem(item, storage);
        } else if (item instanceof Earring earring && earring.type == EarringType.Drop) {
            storage.box.mainSection.add(earring);
            return removeItem(item, storage);
        } else if (item instanceof PendantNecklace pendantNecklace) {
            storage.tree.add(pendantNecklace.chain);
            storage.box.topShelf.add(pendantNecklace.pendant);
            return removeItem(item, storage);
        } else if (item instanceof Necklace necklace) {
            storage.tree.add(necklace);
            return removeItem(item, storage);
        }

        packItem(item, storage, new DefaultJewelleryPacker());
        return true;
    }

    private static boolean removeItem(Jewellery item, JewelleryStorage storage) {
        if (storage.IsInTravelRoll(item)) {
            storage.travelRoll.remove(item);
        }
        return true;
    }

}
