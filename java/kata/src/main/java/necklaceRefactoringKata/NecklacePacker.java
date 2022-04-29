package necklaceRefactoringKata;

import necklaceRefactoringKata.jewellery.Jewellery;
import necklaceRefactoringKata.packers.*;
import org.lambda.query.Queryable;

public class NecklacePacker implements PackLogic {
    @Override
    public boolean pack(Jewellery item, JewelleryStorage storage) {
        return Queryable.as(new DiamondNecklacePacker(),
                new SmallNecklacePacker(),
                new PendantNecklacePacker(),
                new DefaultNecklacePacker()).any(p -> p.pack(item, storage));
    }
}
