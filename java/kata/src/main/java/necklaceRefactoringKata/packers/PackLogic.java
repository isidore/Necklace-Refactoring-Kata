package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;

public interface PackLogic {
    boolean pack(Jewellery item, JewelleryStorage storage);
}
