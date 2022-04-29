package necklaceRefactoringKata;


import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import org.approvaltests.Approvals;
import org.approvaltests.JsonApprovals;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {
    @Test
    void test_AmberBeadsNecklace_IsPackedInTree() {
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);
        var storage = new JewelleryStorage();

        Packer.packNecklace(item, storage);

        JsonApprovals.verifyAsJson(storage);
        // TODO: check if packed in right container
    }
}
