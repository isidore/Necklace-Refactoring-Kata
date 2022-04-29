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
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);
        var storage = new JewelleryStorage();

        Packer.pack(item, storage);
        Packer.pack(new Necklace(Jewel.Diamond, NecklaceType.Beads), storage);
        Packer.pack(new Necklace(Jewel.Amber, NecklaceType.Chain), storage);
        Jewel jewel = Jewel.Plain;
        NecklaceType necklaceType = NecklaceType.LongChain;
        Necklace necklace = new Necklace(jewel, necklaceType);
        Jewellery jewellery = new Pendant(Jewel.Pearl);
        Packer.pack(new PendantNecklace(jewel, necklaceType, necklace, jewellery), storage);

        var jewelleries = new Jewellery[]{};
        for (Jewellery j : jewelleries) {
            Packer.pack(j, storage);
        }

        JsonApprovals.verifyAsJson(storage);
    }
}
