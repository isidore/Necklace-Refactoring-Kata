package necklaceRefactoringKata;


import necklaceRefactoringKata.jewellery.*;
import org.approvaltests.Approvals;
import org.approvaltests.JsonApprovals;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {
    @Test
    void testPackNecklace() {
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);
        var storage = new JewelleryStorage();

        Packer.packNecklace(item, storage);
        Packer.packNecklace(new Necklace(Jewel.Diamond, NecklaceType.Beads), storage);
        Packer.packNecklace(new Necklace(Jewel.Amber, NecklaceType.Chain), storage);
        Jewel jewel = Jewel.Plain;
        NecklaceType necklaceType = NecklaceType.LongChain;
        Necklace necklace = new Necklace(jewel, necklaceType);
        Jewellery jewellery = new Pendant(Jewel.Pearl);
        Packer.packNecklace(new PendantNecklace(jewel, necklaceType, necklace, jewellery), storage);

        JsonApprovals.verifyAsJson(storage);
        // TODO: check if packed in right container
    }
    @Test
    void testPack() {
        var storage = new JewelleryStorage();

        var jewelleries = new Jewellery[]{
                new Necklace(Jewel.Pearl, NecklaceType.Beads),
                new Necklace(Jewel.Diamond, NecklaceType.Beads),
                new Necklace(Jewel.Amber, NecklaceType.Chain),
                new PendantNecklace(Jewel.Plain,
                        NecklaceType.LongChain,
                        new Necklace(Jewel.Plain, NecklaceType.LongChain),
                        new Pendant(Jewel.Pearl)),
                new Earring(Jewel.Amber, EarringType.Stud),
                new Earring(Jewel.Amber, EarringType.Hoop),
                new Earring(Jewel.Amber, EarringType.Drop),
                new Earring(Jewel.Plain, EarringType.Drop),
        };
        for (Jewellery j : jewelleries) {
            Packer.pack(j, storage);
        }

        JsonApprovals.verifyAsJson(storage);
    }
}
