package necklaceRefactoringKata.packers;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.jewellery.Necklace;
import org.lambda.query.Queryable;

public class NecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        if (! (item instanceof Necklace)) {
            return false;
        }
        return Queryable.as(new DiamondNecklacePacker(),
                new SmallNecklacePacker(),
                new PendantNecklacePacker(),
                new DefaultNecklacePacker()).any(p -> p.pack(item, storage));
    }
}
